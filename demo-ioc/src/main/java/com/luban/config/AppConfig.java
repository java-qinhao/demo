package com.luban.config;

import com.luban.dao.UserDaoImpl;
import com.luban.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages  = "com", nameGenerator = MyBeanNameGenerator.class)
@ComponentScan("com.luban")
public class AppConfig {


//    @Bean
//    public UserDaoImpl userDao(){
//        return new UserDaoImpl();
//    }
    @Bean
    public UserService userService(){
        return new UserService();
    }
}
