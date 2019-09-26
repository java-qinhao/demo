package com.luban.config;

import com.luban.annotation.After;
import com.luban.annotation.AopJ;
import com.luban.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@AopJ
public class Aop {
    @Before("com.luban.service")
    public void before(){
        System.out.println("before");
    }
    @After("com.luban.service")
    public void after(){
        System.out.println("after");
    }
}
