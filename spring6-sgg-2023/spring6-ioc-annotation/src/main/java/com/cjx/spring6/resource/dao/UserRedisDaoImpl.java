package com.cjx.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("myUserRedisDaoImpl")
public class UserRedisDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("user redis");
    }
}
