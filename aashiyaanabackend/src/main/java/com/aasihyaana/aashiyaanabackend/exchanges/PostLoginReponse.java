package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PostLoginResponse} class object will be sent to login page frontend as response.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLoginReponse {
    private Boolean isLoginSuccess;
    private Integer activeUserId;
    private String message;
}
