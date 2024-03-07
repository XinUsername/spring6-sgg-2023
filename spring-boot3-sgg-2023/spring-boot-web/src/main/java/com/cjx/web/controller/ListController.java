package com.cjx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list")
    public String list(){
        int i = 1/0;
        return "list";
    }

}
