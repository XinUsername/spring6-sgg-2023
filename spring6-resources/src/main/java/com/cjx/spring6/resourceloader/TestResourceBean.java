package com.cjx.spring6.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestResourceBean {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        ResourceBean resourceBean = context.getBean("resourceBean", ResourceBean.class);
        resourceBean.parse();
    }
}
