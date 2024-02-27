package com.cjx.mvc.controller;

import com.cjx.mvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParam {

    @RequestMapping("/testParam")
    public String testParam(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username +",password = " + password);
        return "param";
    }

    @RequestMapping("/testParam1")
    public String testParam1(String username,String password){
        System.out.println("username = " + username +",password = " + password);
        return "success";
    }

    @RequestMapping("/testParam2")
    public String testParam2(
            @RequestParam(value = "user_name", required = true, defaultValue = "cjx") String username,
            String password){
        System.out.println("username = " + username +",password = " + password);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Host", required = true) String header
    ) {
        System.out.println("header = " + header);
        return "success";
    }

    @RequestMapping("/testCookie")
    public String testCookie(
            HttpServletRequest request,
            @CookieValue(value = "JSESSIONID") String jesseionid
    ){
        HttpSession session = request.getSession();
        System.out.println("jesseionid = " + jesseionid);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testPOJO(User user){
        System.out.println(user);
        return "success";
    }
}
