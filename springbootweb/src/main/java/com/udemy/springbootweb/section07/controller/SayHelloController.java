package com.udemy.springbootweb.section07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        return "<html>" +
                "<head>" +
                "<title>" +
                "Hello World! - HTML" +
                "</title>" +
                "</head>" +
                "<body>" +
                "Hello World! - HTML" +
                "</body>" +
                "</html>";
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }
}
