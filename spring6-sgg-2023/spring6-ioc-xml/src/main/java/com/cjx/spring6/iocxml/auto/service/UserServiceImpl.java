package com.cjx.spring6.iocxml.auto.service;

import com.cjx.spring6.iocxml.auto.dao.UserDao;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        userDao.addUserDao();
        this.userDao = userDao;
    }

    @Override
    public void userAddService() {
        System.out.println("UserService方法执行了");
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}
