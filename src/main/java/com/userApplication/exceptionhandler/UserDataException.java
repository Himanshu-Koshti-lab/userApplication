package com.userApplication.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class UserDataException extends Exception{

    @ExceptionHandler(NullPointerException.class)
    public void error(){
        log.info("Exception Found...");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public void duplicateRecord() {
        log.info("Duplicate email or phone number.");
    }

   /* @ExceptionHandler(HttpMessageNotReadableException.class)
    public void emailValidator() {
        log.info("Email syntax is not valid");
    }*/

}
