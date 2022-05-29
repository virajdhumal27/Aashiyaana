package com.aasihyaana.aashiyaanabackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code User} class holds information about user.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String username;
    private String email;
    private String mobileNumber;
    private String password;
}
