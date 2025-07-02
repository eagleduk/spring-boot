package com.udemy.springbootweb.section08.controller;

import com.udemy.springbootweb.section08.bean.HelloWorldBean;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource m) {
        this.messageSource = m;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello-World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello-World");
    }

    /* Accept-Language */
    @GetMapping("/hello-world-internationalize")
    public String helloWorldInternationalize() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.world.word", null, "Default Message", locale);
    }
}
