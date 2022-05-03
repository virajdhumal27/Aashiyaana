package com.aashiyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetLoginRequest {
    private String email;
    private String password;
}
