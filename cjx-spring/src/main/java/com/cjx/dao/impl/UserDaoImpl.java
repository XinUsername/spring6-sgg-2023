package com.cjx.dao.impl;

import com.cjx.anno.Bean;
import com.cjx.dao.UserDao;

@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void run() {
        System.out.println("dao......");
    }
}