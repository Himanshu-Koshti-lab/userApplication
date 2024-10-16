package com.userApplication.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class UserDataException extends Exception{

    @ExceptionHandler(NullPointerException.class)
    public void error(){
        log.info("Exception Found...");
    }

}
