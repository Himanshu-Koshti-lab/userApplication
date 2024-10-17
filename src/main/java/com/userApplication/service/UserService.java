package com.userApplication.service;

import com.userApplication.entity.UserData;
import com.userApplication.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //    Business Logic
    @Autowired
    UserDataRepository userDataRepository;

    public List<UserData> getAllUsersData() {
        return (List<UserData>) userDataRepository.findAll();
    }

    public UserData getUserByEmail(String email) {
        return userDataRepository.findByEmail(email);
    }

    public UserData getUserByPhoneNumber(Long phoneNumber) {
        return userDataRepository.findByPhoneNumber(phoneNumber);
    }

    public UserData saveUserData(UserData data) {
        return userDataRepository.save(data);
    }
}
