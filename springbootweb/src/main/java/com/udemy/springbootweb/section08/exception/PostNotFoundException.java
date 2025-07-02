package com.udemy.springbootweb.section08.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {
    private String message;

    public PostNotFoundException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
