package com.cjx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/test")
public class RequestMappingController {

    @RequestMapping("/testRequestMapping")
    public String testRequestMapping(){
        return "success";
    }

    @RequestMapping(
            value = {"mapping1", "mapping2"}
    )
    public String testMutiValue(){
        return "success";
    }

    @RequestMapping(
            value = {"test"},
            method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username", "password!=123456"},
            headers = {"Host!=localhost:8081"}
    )
    public String testMethod(){
        return "success";
    }

    @RequestMapping(
            value = {"/a*a/ant"}
    )
    public String testAnt(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id") String id,@PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

}
