package com.userApplication.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class UserDataException extends Exception {

    @ExceptionHandler(NullPointerException.class)
    public void error() {
        log.info("Exception Found...");
    }

    @ExceptionHandler(UserRegistrationException.class)
    public ResponseEntity<String> UserRegistrationException(Exception exception) {
        log.debug("User already found with email or number.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Duplicate email or phone number. Issue with " + exception.getMessage());
    }

   /* @ExceptionHandler(HttpMessageNotReadableException.class)
    public void emailValidator() {
        log.info("Email syntax is not valid");
    }*/

}
