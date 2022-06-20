package com.arka99.springboot.finalerp.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspectService {
    @After(value = "execution(* com.arka99.springboot.finalerp.service.EmployeeService.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("After method:" + joinPoint.getSignature());
    }
}
