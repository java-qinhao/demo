package com.luban;

import com.luban.config.AppConfig;
import com.luban.service.UserService;
import com.luban.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService=(UserService)context.getBean("userServiceImpl");
        userService.query();
    }
}
