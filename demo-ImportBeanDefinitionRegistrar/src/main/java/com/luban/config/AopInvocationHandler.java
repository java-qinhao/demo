package com.luban.config;

import com.luban.holder.ProxyBeanHolder;
import com.luban.util.AopUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

class AopInvocationHandler implements InvocationHandler {
    //目标对象
    Object target;
    //需要植入的方法集
    List<ProxyBeanHolder> proxyBeanHolderList;
    public AopInvocationHandler(Object target, List<ProxyBeanHolder> proxyBeanHolderList){
        this.target=target;
        this.proxyBeanHolderList=proxyBeanHolderList;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (ProxyBeanHolder proxyBeanHolder: proxyBeanHolderList) {
            String annotationName = proxyBeanHolder.getAnnotationName();
            if (annotationName.equals(AopUtil.BEFORE)||annotationName.equals(AopUtil.AROUND))
                this.doProxy(proxyBeanHolder);
        }
        Object result = null;
        try{
            result = method.invoke(target,args);;
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
