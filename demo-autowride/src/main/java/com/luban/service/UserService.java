package com.luban.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService implements User{

    UserService(IndexService indexService){
        System.out.println(1);
    }
    UserService(IndexService indexService,Ao a){
        System.out.println(2);
    }
    public void test() {
        System.out.println("原方法");
    }
}
