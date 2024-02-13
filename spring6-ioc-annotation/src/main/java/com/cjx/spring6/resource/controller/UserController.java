package com.cjx.spring6.resource.controller;

import com.cjx.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller("myUserController")
public class UserController {

    //第一种方式 根据name注入
    @Resource
    private UserService userService;

    public void add(){
        System.out.println("controller...");
        userService.add();
    }
}
