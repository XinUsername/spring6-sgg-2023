package com.cjx.spring6.iocxml.life;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLife {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6 bean对象创建完成，可以使用了");
        System.out.println(user);
        context.close();
    }
}
