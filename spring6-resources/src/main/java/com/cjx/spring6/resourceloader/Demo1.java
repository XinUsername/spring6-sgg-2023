package com.cjx.spring6.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        //通过ApplicationContext访问资源
        //ApplicationContext实例火球Resource实例时，
        //默认才用与ApplicationContext相同的资源访问策略
        Resource res = context.getResource("cjx.txt");
        System.out.println(res.getFilename());
    }
}
