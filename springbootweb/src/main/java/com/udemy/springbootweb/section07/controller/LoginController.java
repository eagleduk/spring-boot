package com.udemy.springbootweb.section07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(ModelMap model, @RequestParam String name) {
        model.put("name", name);
        System.out.println("Login param = " + name);
        return "login";
    }
}
