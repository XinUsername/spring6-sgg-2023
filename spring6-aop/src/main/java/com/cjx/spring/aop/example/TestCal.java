package com.cjx.spring.aop.example;

import org.junit.jupiter.api.Test;

public class TestCal {

    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
        Calculator target = (Calculator)factory.getTarget();
//        target.add(1,2);
//        target.sub(3,2);
//        target.div(3,2);
        target.mul(6,2);
    }
}
