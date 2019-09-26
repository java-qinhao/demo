package com.luban;

import com.luban.dao.*;
import com.luban.util.ProxyUtil;

public class Test {
    public static void main(String[] args) {
//        UserDao userDao=new UserDaoImplPower(new UserDaoImplLog(new UserDaoImpl()));
//        userDao.query();
        UserDao userDao= (UserDao) ProxyUtil.proxy(new UserDaoImpl());
        userDao.query();
    }

}
