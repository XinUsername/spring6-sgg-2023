package com.cjx.spring6.resource.service;

import com.cjx.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("myUserServiceImpl")
public class UserServiceImpl implements UserService {

    //第二种方式 根据name注入
    @Resource(name = "myUserRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
