package com.cjx.spring6.autowrited.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserRedisDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("user redis");
    }
}
