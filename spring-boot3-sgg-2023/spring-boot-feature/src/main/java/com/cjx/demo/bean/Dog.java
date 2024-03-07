package com.cjx.demo.bean;

import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Data
@Component
@Profile("prod")
public class Dog {
    private String name;
    private Integer age;
}
