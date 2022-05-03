package com.aashiyaana.aashiyaanabackend.services;

import com.aashiyaana.aashiyaanabackend.dto.Login;
import com.aashiyaana.aashiyaanabackend.exchanges.GetLoginResponse;

public interface LoginService {

    GetLoginResponse loginUser(Login login);

}
