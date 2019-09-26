package com.luban.config;

import com.luban.holder.ProxyBeanHolder;
import com.luban.util.AopUtil;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

public class CustomizedProxyInterceptor implements MethodInterceptor {
    List<ProxyBeanHolder> proxyBeanHolderList;
   public CustomizedProxyInterceptor(List<ProxyBeanHolder> proxyBeanHolderList){
       this.proxyBeanHolderList = proxyBeanHolderList;
   }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        for (ProxyBeanHolder proxyBeanHolder: proxyBeanHolderList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(AopUtil.BEFORE)||annotationName.equals(AopUtil.AROUND))
                this.doProxy(proxyBeanHolder);
        }
        Object result = null;
        try{
            result = methodProxy.invokeSuper(o, objects);
        }catch (Exception e){
            System.out.println("get ex:"+e.getMessage());
            throw e;
        }
        for (ProxyBeanHolder proxyBeanHolder: proxyBeanHolderList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(AopUtil.AFTER)||annotationName.equals(AopUtil.AROUND))
                this.doProxy(proxyBeanHolder);
        }
        return result;
}

    private void doProxy(ProxyBeanHolder proxyBeanHolder){
        String className = proxyBeanHolder.getClassName();
        String methodName = proxyBeanHolder.getMethodName();
        Object classzz = null;
        try {
            classzz = Class.forName(className);
            Method[] methods = ((Class) classzz).getMethods();
            for (Method poxyMethod:methods)
                if (poxyMethod.getName().equals(methodName))
                    poxyMethod.invoke(((Class) classzz).newInstance(),null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}