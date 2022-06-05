package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PostSignupRequest} class object will hold data from the frontend request for signning up.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSignUpRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
