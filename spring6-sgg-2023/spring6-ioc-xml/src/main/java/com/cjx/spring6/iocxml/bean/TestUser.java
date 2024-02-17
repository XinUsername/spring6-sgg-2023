package com.cjx.spring6.iocxml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //1 根据id 获取Bean
        User user1 = (User)context.getBean("User");
        System.out.println("1 根据id获取Bean:"+user1);
        //2 根据类型 获取Bean
        User user2 = (User)context.getBean(User.class);
        System.out.println("2 根据类型获取Bean:"+user2);
        //3 根据id和类型 获取Bean
        User user3 = (User)context.getBean("User",User.class);
        System.out.println("3 根据id和类型 获取Bean:"+user3);
    }
}
