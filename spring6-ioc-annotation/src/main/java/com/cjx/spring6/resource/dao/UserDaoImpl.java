package com.cjx.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("myUserDaoImpl")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao......");
    }
}
