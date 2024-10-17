package com.userApplication.controller;

import com.userApplication.entity.UserData;
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

    //    find all
    @GetMapping("/getAllUser")
    public List<UserData> getAllUsersData() {
        List<UserData> usr = userService.getAllUsersData();
        return usr;
    }

//    find by email

    @GetMapping("/findByEmail/{email}")
    public UserData getUserByEmail(@PathVariable("email") String email) {

        return userService.getUserByEmail(email);
    }


//    find by phoneNumber

    @GetMapping("/findByPhoneNumber/{phoneNumber}")
    public UserData getUserByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {

        return userService.getUserByPhoneNumber(phoneNumber);
    }

    // Save data

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUserdata(@RequestBody List<UserData> data) {
        for (UserData u : data) {
            userService.saveUserData(u);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User created succesfully");
    }


}
