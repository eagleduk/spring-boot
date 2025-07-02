package com.udemy.springbootweb.section08.exception;

import java.time.LocalDateTime;

public class ExceptionModel {

    private final LocalDateTime time;
    private final String message;
    private final String description;

    public ExceptionModel(LocalDateTime time, String message, String description) {
        this.time = time;
        this.message = message;
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
