package com.aasihyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostLoginRequest {
    private String username;
    private String password;
}
