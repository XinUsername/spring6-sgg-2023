package com.cjx.spring6.iocxml.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TsetScope {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-scope.xml");
        Order bean = context.getBean(Order.class);
        System.out.println(bean);
        Order bean2 = context.getBean(Order.class);
        System.out.println(bean2);
    }
}
