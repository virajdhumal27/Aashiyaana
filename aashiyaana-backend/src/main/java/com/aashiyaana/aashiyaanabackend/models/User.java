package com.aashiyaana.aashiyaanabackend.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Component
public class User {
    private String username;
    private String password;
    private String email;
    private String mobileNumber;
}
