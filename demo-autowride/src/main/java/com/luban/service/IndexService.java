package com.luban.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class IndexService{
    User userService;

//    IndexService(){
//        System.out.println("indexService new");
//    }

//    @Autowired
//    IndexService(User userService){
//        this.userService=userService;
//        System.out.println(111111);
//    }
//    @Autowired
//    IndexService(User userService,User u){
//        this.userService=userService;
//        System.out.println(2222);
//    }
}
