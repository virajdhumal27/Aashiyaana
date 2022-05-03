package com.aashiyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetSignUpRequest {
    private String username;
    private String password;
    private String email;
    private String mobileNumber;
}
