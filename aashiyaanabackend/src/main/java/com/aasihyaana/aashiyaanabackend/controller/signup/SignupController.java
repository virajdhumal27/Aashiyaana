package com.aasihyaana.aashiyaanabackend.controller.signup;

import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(SignupController.SIGNUP_ENDPOINT_API)
public class SignupController {
    public static final String SIGNUP_ENDPOINT_API = "signup";
    public static final String SIGNUP_API = "signupUser";

    @PostMapping(SIGNUP_API)
    public void signupUser(@RequestBody PostSignUpRequest signUpRequest) {
        
    }

}
