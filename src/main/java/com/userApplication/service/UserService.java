package com.userApplication.service;

import com.userApplication.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    //    Business Logic
    @Autowired
    UserDataRepository userDataRepository;

}
