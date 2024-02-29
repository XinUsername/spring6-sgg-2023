package com.cjx.mybatisplusdatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjx.mybatisplusdatasource.dao")
public class MybatisplusDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusDatasourceApplication.class, args);
    }

}
