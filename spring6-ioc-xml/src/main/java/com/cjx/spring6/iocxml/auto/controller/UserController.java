package com.cjx.spring6.iocxml.auto.controller;

import com.cjx.spring6.iocxml.auto.service.UserService;
import com.cjx.spring6.iocxml.auto.service.UserServiceImpl;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        userService.userAddService();
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了");
//        UserService userService = new UserServiceImpl();
//        userService.userAddService();
    }
}
