package com.aasihyaana.aashiyaanabackend.controller.login;

import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(LoginController.LOGIN_ENDPOINT_API)
public class LoginController {
    public static final String LOGIN_ENDPOINT_API = "/login";
    public static final String LOGIN_API = "/loginUser";

    @PostMapping(LOGIN_API)
    public PostLoginReponse checkUser(@RequestBody PostLoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
        return new PostLoginReponse(true, "Successfull");
    }
}
