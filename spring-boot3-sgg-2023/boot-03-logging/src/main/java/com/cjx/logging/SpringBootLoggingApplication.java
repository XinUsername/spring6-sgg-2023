package com.cjx.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringBootLoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoggingApplication.class, args);
    }

}
