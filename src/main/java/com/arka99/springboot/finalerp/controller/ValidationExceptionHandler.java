package com.arka99.springboot.finalerp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidationExceptionHandler extends RuntimeException{

    public ValidationExceptionHandler() {
        validationError();
    }

    @ExceptionHandler(Exception.class)
    public String validationError() {
        return "validationerror";
    }
}
