package com.cjx.service.impl;

import com.cjx.anno.Bean;
import com.cjx.anno.Di;
import com.cjx.dao.UserDao;
import com.cjx.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void run() {
        System.out.println("service...");
        userDao.run();
    }
}
