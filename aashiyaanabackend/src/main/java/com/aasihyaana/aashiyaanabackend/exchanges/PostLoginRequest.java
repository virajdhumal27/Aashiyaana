package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The {@code PostLoginRequest} class object will hold data from the frontend request.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLoginRequest {
    private String username;
    private String password;
}
