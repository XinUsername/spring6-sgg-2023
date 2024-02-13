package com.cjx.spring6.iocxml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJdbc {
    @Test
    public void demo2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean.getPassword());
    }

    @Test
    public void demo1(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("");
        druidDataSource.setUsername("");
        druidDataSource.setPassword("");
        druidDataSource.setDriverClassName("");
    }
}
