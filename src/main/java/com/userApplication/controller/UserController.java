package com.userApplication.controller;

import com.userApplication.entity.UserAddress;
import com.userApplication.entity.UserData;
import com.userApplication.exceptionhandler.UserRegistrationException;
import com.userApplication.response.UserResponse;
import com.userApplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUser")
    public List<UserResponse> getAllUsersData() {
        List<UserResponse> usr = new ArrayList<>();
        for (UserData userData : userService.getAllUsersData()) {
            usr.add(new UserResponse().getUserResponse(userData));
        }
        return usr;
    }

    @GetMapping("/getMasterData")
    public List<UserData> masterData() {
        List<UserData> data = userService.getAllUsersData();
        return data;
    }

    @GetMapping("/findByEmail/{email}")
    public UserResponse getUserByEmail(@PathVariable("email") String email) {
        return new UserResponse().getUserResponse(userService.getUserByEmail(email));
    }

    @GetMapping("/findByPhoneNumber/{phoneNumber}")
    public UserResponse getUserByPhoneNumber(@PathVariable("phoneNumber") Long phoneNumber) {

        return new UserResponse().getUserResponse(userService.getUserByPhoneNumber(phoneNumber));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUserdata(@RequestBody UserData userData) throws UserRegistrationException {
        if (userService.getUserByPhoneNumber(userData.getPhoneNumber()) == null) {
            if (userService.getUserByEmail(userData.getEmail()) == null) {
                userData.setPassword(new BCryptPasswordEncoder().encode(userData.getPassword()));
                List<UserAddress> addresses = new ArrayList<>();
                for (UserAddress ur : userData.getUserAddress()) {
                    addresses.add(ur);
                }
                userData.setUserAddress(addresses);
                userService.saveUserData(userData);
                return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
            } else {
                throw new UserRegistrationException("Something Went wrong with email.");
            }
        } else {
            throw new UserRegistrationException("Something Went wrong with phone number.");
        }
    }

    @GetMapping("/setupRep")
    public ResponseEntity<String> setUp() {
        userService.setUpData();
        return ResponseEntity.status(HttpStatus.OK).body("done");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginMethod(@RequestParam String email, @RequestParam String password) {

        UserData userByEmail = userService.getUserByEmail(email);

        if (new BCryptPasswordEncoder().matches(password, userByEmail.getPassword())) {
            return ResponseEntity.status(HttpStatus.OK).body("Login successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Login Failed");
    }

    @GetMapping("/forgetPassword")
    public ResponseEntity<String> forgetPass(@RequestParam String email) {
        if (userService.getUserByEmail(email) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not found.");

        userService.updatePassword(email);

        return ResponseEntity.status(HttpStatus.OK).body("Password update : DefaultPassword");
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {

        if (userService.getUserByEmail(email) != null) {
            System.out.println("user found");
            userService.deleteUserByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).body(email + " deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email + " Not found");
    }
    @DeleteMapping("/deleteUsersAddress/{email}/{aId}")
    public ResponseEntity<String> deleteUsersAddress(@PathVariable("email") String email, @PathVariable("aId") Long aId) {

        if (userService.getUserByEmail(email) != null && userService.getAddressById(aId)!=null) {
            System.out.println("user found");
            userService.deleteAddress(aId);
            return ResponseEntity.status(HttpStatus.OK).body(email + " address deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(email + " Not found");
    }


}
