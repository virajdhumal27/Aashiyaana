package com.aashiyaana.aashiyaanabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUp {
    private String username;
    private String password;
    private String email;
    private String mobileNumber;
}
