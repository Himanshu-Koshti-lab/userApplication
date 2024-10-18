package com.userApplication.response;

import com.userApplication.entity.UserData;
import lombok.Data;

@Data
public class UserResponse {

    String name;
    String gender;
    String email;
    Integer roleId;

    public UserResponse getUserResponse(UserData userData) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(userData.getFirstName() + " " + userData.getLastName());
        userResponse.setGender(userData.getGender());
        userResponse.setEmail(userData.getEmail());
        userResponse.setRoleId(userData.getRoleId());
        return userResponse;
    }
}
