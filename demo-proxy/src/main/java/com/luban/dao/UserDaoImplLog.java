package com.luban.dao;

public class UserDaoImplLog implements UserDao {
    private UserDao userDao;
    public UserDaoImplLog(UserDao userDao){
        this.userDao=userDao;
    }

    public void query() {
        System.out.println("-----------log-------");
        userDao.query();
    }
}
