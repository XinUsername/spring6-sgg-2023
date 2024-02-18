package com.cjx.spring6;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject(){
        //加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        User user = (User)context.getBean("user");
        System.out.println("1:"+user);
        //使用对象调用方法
        System.out.print("2:");
        user.add();

        // 手动写日志
        logger.info("### 执行成功");
    }

    //反射创建对象
    @Test
    public void testUserObject1() throws Exception {
        Class<?> clazz = Class.forName("com.cjx.spring6.User");
//        Object o = clazz.newInstance();//jdk17弃用
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        user.add();
    }
}
