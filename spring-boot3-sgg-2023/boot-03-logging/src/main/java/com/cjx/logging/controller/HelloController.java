package com.cjx.logging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(getClass());// 或者使用@Slf4j注解

    @GetMapping("/h")
    public String hello(String a, String b){
        // 测试日志
        logger.error("error");
        logger.warn("warn");
        logger.info("info b:{}, a:{}",a , b);
        logger.debug("debug");
        logger.trace("trace");
        return "hello";
    }
}
