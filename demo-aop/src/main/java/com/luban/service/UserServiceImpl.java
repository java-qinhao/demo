package com.luban.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public String query(String str){
        System.out.println("query");
        return str;
    }
}
