package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PostLogoutResponse} class object will hold data to the frontend request for logging out.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLogoutResponse {
    private Boolean isLogoutSuccess;
    private String message;
}
