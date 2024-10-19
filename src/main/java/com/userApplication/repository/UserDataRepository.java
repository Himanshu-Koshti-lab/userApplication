package com.userApplication.repository;

import com.userApplication.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    
    UserData findByEmail(String email);
    
    UserData findByPhoneNumber(Long phoneNumber);
    
    void deleteByEmail(String email);
}
