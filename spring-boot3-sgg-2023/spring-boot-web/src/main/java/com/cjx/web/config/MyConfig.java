package com.cjx.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

//@EnableWebMvc //禁用boot的默认配置
@Configuration
public class MyConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //保留之前的配置
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//        //自己写的配置
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/a/","classpath:/b/")
//                .setCacheControl(CacheControl.maxAge(1180, TimeUnit.SECONDS));
//
//    }

}
