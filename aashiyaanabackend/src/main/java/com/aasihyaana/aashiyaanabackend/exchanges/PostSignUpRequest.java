package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.Data;

@Data
public class PostSignUpRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
