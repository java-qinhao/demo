package com.luban;

import com.luban.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
        Object userService = ac.getBean("userService");
        System.out.println(userService);
//        System.out.println(ac.getBean("userMapper"));
    }
}
