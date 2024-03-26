package com.cjx.springboot;

import com.cjx.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BootApplicationTest {

    @Autowired
    private Person person;

    @Test
    public void test01(){
        // 读取配置文件中的属性 application.yml/application.properties
        System.out.println(person);
    }

}
