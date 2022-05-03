package com.aashiyaana.aashiyaanabackend.exchanges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLoginResponse {
    private Boolean isSuccessfull;
    private String message;
}
