package com.luban.util;

import com.luban.holder.ProxyBeanHolder;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AopUtil {
    /**
     * aop标识注解类
     */
    public static final String AOP_POINTCUT_ANNOTATION
            = "com.luban.annotation.AopJ";
    /**
     * 前置通知注解类
     */
    public static final String BEFORE
            = "com.luban.annotation.Before";
    /**
     * 后置通知注解类
     */
    public static final String AFTER
            = "com.luban.annotation.After";
    /**
     * 环绕通知注解类
     */
    public static final String AROUND
            = "com.luban.annotation.Around";
    /**
     * 代理方式 false:jdk动态代理  true:cglib代理
     */
    public static boolean cglib;
    /**
     * 存放需代理的全部目标对象类
     */
    public static volatile Map<String, List<ProxyBeanHolder>> classzzProxyBeanHolder = new ConcurrentHashMap<String, List<ProxyBeanHolder>>();
}
