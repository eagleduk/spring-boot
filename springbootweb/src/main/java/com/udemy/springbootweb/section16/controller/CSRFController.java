package com.udemy.springbootweb.section16.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CSRFController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static List<String> lists = new ArrayList<>(Arrays.asList("first", "second", "3rd"));

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest http) {
        return (CsrfToken) http.getAttribute("_csrf");
    }

    @GetMapping("/list")
    public List<String> getLists() {
        return lists;
    }

    @GetMapping("/list/{index}")
    public String getIndexString(@PathVariable int index) {
        return lists.get(index);
    }

    @PostMapping("/list")
    public void setString(@RequestBody ListBody l) {

        logger.info("Post ===> {} ", l);

        lists.add(l.string);
    }

    record ListBody(String string) {}
}
