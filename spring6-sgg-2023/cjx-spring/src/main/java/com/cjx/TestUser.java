package com.cjx;

import com.cjx.bean.AnnotationApplicationContext;
import com.cjx.bean.ApplicationContext;
import com.cjx.service.UserService;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("com.cjx");
        UserService userService = (UserService)context.getBean(UserService.class);
        userService.run();
    }
}
