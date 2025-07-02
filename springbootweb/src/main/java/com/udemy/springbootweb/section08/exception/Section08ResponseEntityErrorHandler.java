package com.udemy.springbootweb.section08.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class Section08ResponseEntityErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionModel> handleAllException(Exception ex, WebRequest request) throws Exception {
        ExceptionModel exception = new ExceptionModel(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ExceptionModel>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionModel> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ExceptionModel exception = new ExceptionModel(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ExceptionModel>(exception, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ExceptionModel exception = new ExceptionModel(LocalDateTime.now(), Objects.requireNonNull(ex.getFieldError()).getDefaultMessage(), request.getDescription(false));

        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
