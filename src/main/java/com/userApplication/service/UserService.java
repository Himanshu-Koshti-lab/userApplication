package com.userApplication.service;

import com.userApplication.entity.UserAddress;
import com.userApplication.entity.UserData;
import com.userApplication.repository.UserAddressRepository;
import com.userApplication.repository.UserDataRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.userApplication.util.EncoderUtil.encodedString;

@Service
public class UserService {

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    UserAddressRepository userAddressRepository;

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

    public void setUpData() {

        List<UserData> userList = new ArrayList<>();

        // User 1 with 3 addresses (1 primary, 2 secondary)
        UserData user1 = new UserData(1L, "Pallavee", "Jarad", "Female", new Date(), "pallavee@example.com", 1746649992L, encodedString("pwd1"), 1, null);
        user1.setUserAddress(Arrays.asList(
                new UserAddress(1L, "123 Main St", "Apt 101", "City1", 2, 12345, true, user1),
                new UserAddress(2L, "456 Side St", "Apt 202", "City1", 4, 12346, false, user1),
                new UserAddress(3L, "789 High St", "Apt 303", "City1", 6, 12347, false, user1)
        ));
        userList.add(user1);

        // User 2 with 2 addresses (1 primary, 1 secondary)
        UserData user2 = new UserData(2L, "Amit", "Sharma", "Male", new Date(), "amit@example.com", 1746648881L, encodedString("pwd2"), 2, null);
        user2.setUserAddress(Arrays.asList(
                new UserAddress(4L, "101 Center St", "Apt 404", "City2", 32, 67890, true, user2),
                new UserAddress(5L, "202 Hill St", "Apt 505", "City2", 8, 67891, false, user2)
        ));
        userList.add(user2);

        // User 3 with 2 addresses (1 primary, 1 secondary)
        UserData user3 = new UserData(3L, "Ravi", "Kumar", "Male", new Date(), "ravi@example.com", 1746648770L, encodedString("pwd3"), 3, null);
        user3.setUserAddress(Arrays.asList(
                new UserAddress(6L, "303 Valley St", "Apt 606", "City3", 6, 54321, true, user3),
                new UserAddress(7L, "404 River St", "Apt 707", "City3", 8, 54322, false, user3)
        ));
        userList.add(user3);

        // User 4 with 1 address (primary)
        UserData user4 = new UserData(4L, "Sunita", "Verma", "Female", new Date(), "sunita@example.com", 1746648669L, encodedString("pwd4"), 2, null);
        user4.setUserAddress(Arrays.asList(
                new UserAddress(8L, "505 Oak St", "Apt 808", "City4", 3, 98765, true, user4)
        ));
        userList.add(user4);

        // User 5 with 3 addresses (1 primary, 2 secondary)
        UserData user5 = new UserData(5L, "Vikram", "Singh", "Male", new Date(), "vikram@example.com", 1746648558L, encodedString("pwd5"), 3, null);
        user5.setUserAddress(Arrays.asList(
                new UserAddress(9L, "606 Pine St", "Apt 909", "City5", 23, 11223, true, user5),
                new UserAddress(10L, "707 Elm St", "Apt 1010", "City5", 12, 11224, false, user5),
                new UserAddress(11L, "808 Cedar St", "Apt 1111", "City5", 21, 11225, false, user5)
        ));
        userList.add(user5);

        userDataRepository.deleteAll();
        userDataRepository.saveAll(userList);
    }

    @Transactional
    public void deleteUserByEmail(String email) {
        userDataRepository.deleteByEmail(email);
    }

    @Transactional
    public void deleteAddress(Long aId) {
        userAddressRepository.deleteByAddressId(aId);
    }

    @Transactional
    public Optional<UserAddress> getAddressById(Long aId) {
        Optional<UserAddress> userAddress = userAddressRepository.findById(aId);
        return userAddress;

    }
}