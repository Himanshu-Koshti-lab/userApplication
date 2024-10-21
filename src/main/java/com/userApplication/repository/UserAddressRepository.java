package com.userApplication.repository;

import com.userApplication.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    void deleteByAddressId(Long aId);
}
