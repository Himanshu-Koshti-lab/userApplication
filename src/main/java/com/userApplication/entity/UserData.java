package com.userApplication.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    String firstName;

    String lastName;

    String gender;

    Date dateOfBirth;

    String email;

    Long phoneNumber;

    String password;

    Integer roleId;

    @OneToMany(mappedBy = "userData", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<UserAddress> userAddress;
}
