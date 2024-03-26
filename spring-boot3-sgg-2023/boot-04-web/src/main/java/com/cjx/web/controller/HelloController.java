package com.cjx.web.controller;

import com.cjx.web.bean.Person;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    // 新版path_pattern_parser /**只能放在末尾
    @GetMapping("/a*/b?/**/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path){
        log.info("路径变量：{}", path);
        //获取请求路径
        String uri = request.getRequestURI();
        return uri;
    }

    @GetMapping("/person")
    public Person person(){
        Person person = new Person();
        person.setId(1L);
        person.setEmail("person@qq.com");
        person.setUserName("zhangsan");
        person.setAge(18);
        return person;
    }

}
