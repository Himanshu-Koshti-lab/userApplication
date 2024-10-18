package com.userApplication.service;

import com.userApplication.entity.UserData;
import com.userApplication.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.userApplication.util.EncoderUtil.encodedString;

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

    public void setUpData(){

        List<UserData> userList = new ArrayList<>();

        userList.add(new UserData(1L, "Pallavee", "Jarad", "Female", new Date(), "pallavee@example.com", 1746649992L, encodedString("pwd1"), 1));
        userList.add(new UserData(2L, "Rahul", "Sharma", "Male", new Date(), "rahul.sharma@example.com", 1876654321L, encodedString("pwd2"), 2));
        userList.add(new UserData(3L, "Sneha", "Verma", "Female", new Date(), "sneha.verma@example.com", 1938765432L, encodedString("pwd2"), 2));
        userList.add(new UserData(4L, "Amit", "Patel", "Male", new Date(), "amit.patel@example.com", 1654321876L, encodedString("pwd2"), 0));
        userList.add(new UserData(5L, "Kiran", "Kumar", "Male", new Date(), "kiran.kumar@example.com", 1546738921L, encodedString("pwd2"), 2));
        userList.add(new UserData(6L, "Priya", "Deshmukh", "Female", new Date(), "priya.deshmukh@example.com", 1765439211L, encodedString("pwd2"), 2));
        userList.add(new UserData(7L, "Anil", "Reddy", "Male", new Date(), "anil.reddy@example.com", 1845672199L, encodedString("pwd2"), 1));
        userList.add(new UserData(8L, "Neha", "Singh", "Female", new Date(), "neha.singh@example.com", 1998765432L, encodedString("pwd2"), 2));
        userList.add(new UserData(9L, "Vikas", "Joshi", "Male", new Date(), "vikas.joshi@example.com", 1745623981L, encodedString("pwd2"), 1));
        userList.add(new UserData(10L, "Sonia", "Mehra", "Female", new Date(), "sonia.mehra@example.com", 1234567890L, encodedString("pwd2"), 1));

        userDataRepository.saveAll(userList);
    }



}
