package com.luban.config;

import com.luban.holder.ProxyBeanHolder;
import com.luban.util.AopUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    /**
     * 存放需要代理的相关信息类
     */
    public static volatile List<ProxyBeanHolder> roxyBeanHolderList = new Vector<ProxyBeanHolder>();

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //首先获得所有的bdName集合
        String[] beanDefintionNames=configurableListableBeanFactory.getBeanDefinitionNames();
        for(String beanDefintionName : beanDefintionNames){
            BeanDefinition beanDefinition=configurableListableBeanFactory.getBeanDefinition(beanDefintionName);
            if(beanDefinition instanceof AnnotatedBeanDefinition){//判断bd是不是一个注解类
                //获得bd上的所有注解
                AnnotationMetadata annotationMetadata=((AnnotatedBeanDefinition)((AnnotatedBeanDefinition) beanDefinition)).getMetadata();
                Set<String> annotations=annotationMetadata.getAnnotationTypes();
                //循环该bd上的所有注解
                for(String annotation:annotations){
                    if(annotation.equals(AopUtil.AOP_POINTCUT_ANNOTATION)){//如果是aop类型的注解，则对此bd进行解析
                        doScan((GenericBeanDefinition)beanDefinition);
                    }
                }
            }
        }
    }

    /**
     * 扫描所有注解方法
     * @param beanDefinition
     */
    private void doScan(GenericBeanDefinition beanDefinition){
        try {
            //首先拿到bd对应的class，
            String className=beanDefinition.getBeanClassName();
            Class<?> clazz=Class.forName(className);
            //拿到类下面的所有方法
            Method[] methods=clazz.getMethods();
            for(Method method:methods){
                //拿到方法的注解
                Annotation[] annotations=method.getAnnotations();
                //循环方法上的所有注解
                for(Annotation annotation:annotations){
                    //判断注解是不是我们定义的aop方法注解，如果是，则进行解析
                    String annotationTypeName=annotation.annotationType().getName();
                    if(annotationTypeName.equals(AopUtil.BEFORE)||
                            annotationTypeName.equals(AopUtil.AFTER)||
                                    annotationTypeName.equals(AopUtil.AROUND)){
                        doScan(className,method,annotation);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描出所有需要被代理的类
     * @param className
     * @param method
     * @param annotation
     */
    private void  doScan(String className,Method method,Annotation annotation){
        ProxyBeanHolder proxyBeanHolder=new ProxyBeanHolder();
        proxyBeanHolder.setClassName(className);
        proxyBeanHolder.setMethodName(method.getName());
        proxyBeanHolder.setAnnotationName(annotation.annotationType().getName());
        //获取注解上的扫描包路径
        Method[] annotationMethods=annotation.annotationType().getMethods();
        String packagePath = null;
        for(Method annotationMethod:annotationMethods){
            if(annotationMethod.getName().equals("value")){
                try {
                    packagePath = (String) annotationMethod.invoke(annotation, null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        //获取包路径下的所有class文件
        if (packagePath!=""&&packagePath!=null){
            String rootPath = this.getClass().getResource("/").getPath();
            String targetPackagePath =rootPath+packagePath.replace(".","/");
            File file=new File(targetPackagePath);
            File[] fileList=file.listFiles();
            List<ProxyBeanHolder> lroxyBeanHolderList = null;
            for(File classFile:fileList){
                if(classFile.isFile()){//如果是文件
                    String targetClass = packagePath+"."+classFile.getName().replace(".class","");
                    try {
                        lroxyBeanHolderList = AopUtil.classzzProxyBeanHolder.get(targetClass);
                    }catch(Exception e){
                    }
                    if (lroxyBeanHolderList==null){
                        lroxyBeanHolderList = new Vector<ProxyBeanHolder>();
                    }
                    lroxyBeanHolderList.add(proxyBeanHolder);
                    AopUtil.classzzProxyBeanHolder.put(targetClass,lroxyBeanHolderList);
                }
            }
        }
    }
}
