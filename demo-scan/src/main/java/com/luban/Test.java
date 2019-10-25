package com.luban;

import com.luban.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
        System.out.println(ac.getBean("userService"));
//        System.out.println(ac.getBean("userMapper"));
    }
}
