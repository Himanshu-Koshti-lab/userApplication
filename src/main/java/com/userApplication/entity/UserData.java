package com.userApplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    @Column(unique = true)
    //@Email(message = "Email should be valid")
    //@NotBlank(message = "Email is mandatory")
    String email;

    @Column(unique = true)
    Long phoneNumber;

    String password;

    Integer roleId;

}
