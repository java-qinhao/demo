package com.luban.config;

import com.luban.util.AopUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        String targetClass = bean.getClass().getName();
        Object object = bean;
        if (AopUtil.classzzProxyBeanHolder.containsKey(targetClass)){
            //cjlib代理
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(object.getClass());
//            enhancer.setCallback(new CustomizedProxyInterceptor(ConfigurationUtil.classzzProxyBeanHolder.get(targetClass)));
//            object =  enhancer.create();
            //创建jdk动态代理对象
            Class<?> sup=null;
            try {
                sup=Class.forName((object.getClass().getInterfaces())[0].getName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            object= Proxy.newProxyInstance(MyBeanPostProcessor.class.getClassLoader(),
                                            new Class[]{sup},
                                            new AopInvocationHandler(object, AopUtil.classzzProxyBeanHolder.get(targetClass)));
        }
        return object;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
