package com.luban.dao;

import com.luban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    UserService userService;
    public void query() {
        System.out.println("dao");
    }
}
