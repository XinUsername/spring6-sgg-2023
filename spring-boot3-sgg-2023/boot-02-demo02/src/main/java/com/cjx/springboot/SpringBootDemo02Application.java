package com.cjx.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemo02Application {

    public static void main(String[] args) {
        //java10： 局部变量类型自动推断
        var ioc = SpringApplication.run(SpringBootDemo02Application.class, args);

        //1.获取容器中所有组件的名字
        String[] names = ioc.getBeanDefinitionNames();
        //2.遍历
        //SpringBoot把以前配置的核心组件，现在都自动配置好了
        for (String name : names) {
            System.out.println(name);
        }

    }

}
