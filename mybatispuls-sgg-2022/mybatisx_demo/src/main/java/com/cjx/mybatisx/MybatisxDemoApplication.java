package com.cjx.mybatisx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjx.mybatisx.mapper")
public class MybatisxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisxDemoApplication.class, args);
    }

}
