package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PostSignupResponse} class object will hold data to the frontend response for signning up.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSignupResponse {
    private Boolean isSignupSuccess;
    private String message;
}
