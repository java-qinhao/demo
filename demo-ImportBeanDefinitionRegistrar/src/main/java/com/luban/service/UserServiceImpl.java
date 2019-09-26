package com.luban.service;

import com.luban.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    public void query() {
        System.out.println("service");
        userDao.query();
    }
}
