package com.luban.dao;

public class UserDaoImplPower implements UserDao {
    private UserDao userDao;
    public UserDaoImplPower(UserDao userDao){
        this.userDao=userDao;
    }

    public void query() {
        System.out.println("-----------power-------");
        userDao.query();
    }
}
