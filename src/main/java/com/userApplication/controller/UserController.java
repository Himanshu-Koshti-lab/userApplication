package com.userApplication.controller;

import com.userApplication.entity.UserData;
import com.userApplication.exceptionhandler.UserRegistrationException;
import com.userApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<UserData> getAllUsersData() {
        List<UserData> usr = userService.getAllUsersData();
        return usr;
    }

    @GetMapping("/findByEmail/{email}")
    public UserData getUserByEmail(@PathVariable("email") String email) {

        return userService.getUserByEmail(email);
    }

    @GetMapping("/findByPhoneNumber/{phoneNumber}")
    public UserData getUserByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {

        return userService.getUserByPhoneNumber(phoneNumber);
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUserdata(@RequestBody UserData userData) throws UserRegistrationException {
        if (userService.getUserByPhoneNumber(userData.getPhoneNumber()) == null) {
            if (userService.getUserByEmail(userData.getEmail()) == null) {
                userService.saveUserData(userData);
                return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
            } else {
                throw new UserRegistrationException("Something Went wrong with email.");
            }
        } else {
            throw new UserRegistrationException("Something Went wrong with phone number.");
        }
    }

}
