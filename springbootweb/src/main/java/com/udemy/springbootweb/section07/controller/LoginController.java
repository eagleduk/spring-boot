package com.udemy.springbootweb.section07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        logger.debug("Login");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcome(ModelMap model, @RequestParam String name, @RequestParam String password) {
        model.put("name", name);
        model.put("password", password);
        logger.debug("name: {}, password: {}", name, password);
        return "welcome";
    }
}
