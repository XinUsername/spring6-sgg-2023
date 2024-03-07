package com.cjx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(@RequestParam("name") String name,
                          Model model){
        model.addAttribute("msg",name);
        //真实地址：classpath:/templates/welcome.html
        return "welcome";
    }

}
