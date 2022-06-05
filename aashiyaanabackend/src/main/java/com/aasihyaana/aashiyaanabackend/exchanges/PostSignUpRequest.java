package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSignUpRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
