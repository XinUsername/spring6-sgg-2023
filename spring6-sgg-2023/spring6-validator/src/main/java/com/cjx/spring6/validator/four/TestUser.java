package com.cjx.spring6.validator.four;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService service = context.getBean(MyService.class);
        User user = new User();
        user.setName("lulu");
        user.setPhone("13231231323");
        user.setMessage("abc bcd");
        service.testMethod(user);
    }
}
