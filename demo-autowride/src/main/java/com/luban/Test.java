package com.luban;

import com.luban.config.Appconfig;
import com.luban.service.IndexService;
import com.luban.service.User;
import com.luban.service.UserService;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(Appconfig.class);
        User bean = (User)ac.getBean("userService");
        bean.test();
    }
}
