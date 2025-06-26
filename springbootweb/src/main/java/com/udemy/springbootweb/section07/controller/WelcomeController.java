package com.udemy.springbootweb.section07.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}
