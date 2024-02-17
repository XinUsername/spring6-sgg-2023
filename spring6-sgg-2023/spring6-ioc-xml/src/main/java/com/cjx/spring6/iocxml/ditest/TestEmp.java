package com.cjx.spring6.iocxml.ditest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-dilist.xml");
//        Emp emp = context.getBean("emp", Emp.class);
//        emp.work();
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }
}
