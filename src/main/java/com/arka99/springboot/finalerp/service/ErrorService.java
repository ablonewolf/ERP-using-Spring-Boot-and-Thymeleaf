package com.arka99.springboot.finalerp.service;

import com.arka99.springboot.finalerp.controller.ValidationExceptionHandler;
import org.springframework.stereotype.Service;

@Service
public class ErrorService {
    public void throwError() throws ValidationExceptionHandler {
        throw new ValidationExceptionHandler();
    }
}
