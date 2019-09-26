package com.luban.service;

import com.luban.dao.UserDao;
import com.luban.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserService {
//    @Autowired
//    UserDao userDao;
@Bean
public UserDaoImpl userDao(){
    return new UserDaoImpl();
}

    public UserService(){
        System.out.println("构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    @PreDestroy
    public void desproy(){
        System.out.println("desproy");
    }
}
