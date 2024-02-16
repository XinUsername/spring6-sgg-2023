package com.atguigu.spring6.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;


public class Demo1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //传递动态参数，使用数组形式对应{0} {1}顺序
        Object[] objects = new Object[]{"cjx", new Date().toString()};
        //www.cjx.com为资源文件的key值，
        //objects为资源文件value值所有需要的参数，local.CHINA为国际化语言
        String message = context.getMessage("www.cjx.com", objects, Locale.CHINA);
        System.out.println(message);
    }
}
