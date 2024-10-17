package com.userApplication.service;

import com.userApplication.entity.UserData;
import com.userApplication.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    public void saveUserData(UserData data) {
        userDataRepository.save(data);
    }

    public void updatePassword(String Email) {
        UserData userByEmail = userDataRepository.findByEmail(Email);
        userByEmail.setPassword(new BCryptPasswordEncoder().encode("DefaultPassword"));
        userDataRepository.save(userByEmail);
    }

}
