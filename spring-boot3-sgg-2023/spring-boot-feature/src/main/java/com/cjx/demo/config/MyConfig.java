package com.cjx.demo.config;

import com.cjx.demo.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class MyConfig {

//    @Profile("prod")
    @Bean
    public Person person(){
        return new Person();
    }

}
