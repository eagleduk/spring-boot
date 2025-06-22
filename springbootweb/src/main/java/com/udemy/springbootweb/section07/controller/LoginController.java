package com.udemy.springbootweb.section07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/login")
    public String login(ModelMap model, @RequestParam String name) {
        model.put("name", name);
        logger.debug("Login param = {}", name);
        return "login";
    }
}
