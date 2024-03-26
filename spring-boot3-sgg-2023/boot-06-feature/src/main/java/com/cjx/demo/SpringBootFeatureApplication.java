package com.cjx.demo;

import com.cjx.demo.bean.Cat;
import com.cjx.demo.bean.Child;
import com.cjx.demo.bean.Dog;
import com.cjx.demo.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringBootFeatureApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SpringBootFeatureApplication, args)

//        SpringApplication application = new SpringApplication(SpringBootFeatureApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.run(args);

        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .sources(SpringBootFeatureApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .run(args);
        try {
            Cat cat = context.getBean(Cat.class);
            log.info("类型cat{}",cat);
        }catch (Exception e){}
        try {
            Child child = context.getBean(Child.class);
            log.info("类型child{}",child);
        }catch (Exception e){}
        try {
            Dog dog = context.getBean(Dog.class);
            log.info("类型dog{}",dog);
        }catch (Exception e){}
        try {
            Person person = context.getBean(Person.class);
            log.info("类型person{}",person);
        }catch (Exception e){}


    }

}
