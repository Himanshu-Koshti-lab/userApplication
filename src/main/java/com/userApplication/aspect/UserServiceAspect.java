package com.userApplication.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceAspect.class);

    // This advice will run before the execution of any method in com.example.service package
    @Before("execution(* com.userApplication.service.*.*(..))")
    public void logBeforeMethod() {
        logger.info("Method execution started.");
    }

    // This advice will run after the execution of any method in com.example.service package
    @After("execution(* com.userApplication.service.*.*(..))")
    public void logAfterMethod() {
        logger.info("Method execution completed.");
    }

    // This advice will run around the execution of any method in com.example.service package
    @Around("execution(* com.userApplication.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before method: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();  // Proceed with method execution
        logger.info("After method: " + joinPoint.getSignature().getName());
        return result;
    }

}