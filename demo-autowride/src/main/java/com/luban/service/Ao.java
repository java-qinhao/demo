package com.luban.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Ao {
    @Before("execution(public * *(..))")
    public void BeforeM(){
        System.out.println("before");
    }
    @After("execution(public * *(..))")
    public void AfterM(){
        System.out.println("after");
    }
}
