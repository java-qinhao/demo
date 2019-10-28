package com.luban.service;

import com.luban.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserService
{
//    @Autowired
//    UserMapper userMapper;
    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @Bean
    public UserMapper userMapper(){
        return new UserMapper();
    }
}
