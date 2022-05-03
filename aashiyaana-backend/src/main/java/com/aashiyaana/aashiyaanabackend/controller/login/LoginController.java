package com.aashiyaana.aashiyaanabackend.controller.login;

import com.aashiyaana.aashiyaanabackend.dto.Login;
import com.aashiyaana.aashiyaanabackend.exchanges.GetLoginRequest;
import com.aashiyaana.aashiyaanabackend.exchanges.GetLoginResponse;
import com.aashiyaana.aashiyaanabackend.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginController {

    @Autowired
    private LoginService loginService;

    GetLoginResponse loginUser(GetLoginRequest getLoginRequest) {

        Login newUserLogin = new Login(getLoginRequest.getEmail(), getLoginRequest.getPassword());
        GetLoginResponse response = loginService.loginUser(newUserLogin);

        return response;
    }
}
