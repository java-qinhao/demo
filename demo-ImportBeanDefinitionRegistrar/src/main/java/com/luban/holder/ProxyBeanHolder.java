package com.luban.holder;

public class ProxyBeanHolder {
    //AOP通知类名称
    private volatile String className;
    //通知方法名称
    private volatile String methodName;
    //注解类名称
    private volatile String annotationName;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getAnnotationName() {
        return annotationName;
    }

    public void setAnnotationName(String annotationName) {
        this.annotationName = annotationName;
    }
}
