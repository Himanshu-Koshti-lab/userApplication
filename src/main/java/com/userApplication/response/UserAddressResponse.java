package com.userApplication.response;

import com.userApplication.entity.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressResponse {

    String Street1;
    String Street2;
    String city;
    State state;
    Integer pinCode;
}

