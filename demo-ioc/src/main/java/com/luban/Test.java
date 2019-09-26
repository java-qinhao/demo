package com.luban;

import com.luban.config.AppConfig;
import com.luban.dao.UserDao;
import com.luban.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService= (UserService) applicationContext.getBean("com.luban.service.UserService");
//        AppConfig appConfig= (AppConfig) applicationContext.getBean("appConfig");
//        UserService userService= (UserService) applicationContext.getBean("userService");
//        UserService userService1= (UserService) applicationContext.getBean("userService");
//        System.out.println(userService.hashCode());
//        System.out.println(userService1.hashCode());
        UserDao userDao= (UserDao) applicationContext.getBean("userDaoImpl");
    }

}
