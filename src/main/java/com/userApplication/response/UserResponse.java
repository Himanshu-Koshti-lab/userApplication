package com.userApplication.response;

import com.userApplication.entity.UserAddress;
import com.userApplication.entity.UserData;
import com.userApplication.entity.enums.Role;
import com.userApplication.entity.enums.State;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {

    String name;
    String gender;
    String email;
    Role role;
    UserAddressResponse address;

    public UserResponse getUserResponse(UserData userData) {
        UserResponse userResponse = new UserResponse();

        userResponse.setName(userData.getFirstName() + " " + userData.getLastName());
        userResponse.setGender(userData.getGender());
        userResponse.setEmail(userData.getEmail());
        userResponse.setRole(Role.getByValue(userData.getRoleId()));
        List<UserAddress> list = userData.getUserAddress();
        for (UserAddress usrData : list) {
            if (usrData.getIsPrimary()) {
                UserAddressResponse userAddressResponse = new UserAddressResponse();
                userAddressResponse.setStreet1(usrData.getStreet1());
                userAddressResponse.setStreet2(usrData.getStreet2());
                userAddressResponse.setState(State.getByValue(usrData.getState()));
                userAddressResponse.setCity(usrData.getCity());
                userAddressResponse.setPinCode(usrData.getPinCode());
                userResponse.setAddress(userAddressResponse);
            }

        }
        return userResponse;
    }
}
