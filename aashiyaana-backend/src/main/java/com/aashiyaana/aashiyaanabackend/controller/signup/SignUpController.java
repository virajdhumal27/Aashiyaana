package com.aashiyaana.aashiyaanabackend.controller.signup;

import com.aashiyaana.aashiyaanabackend.dto.SignUp;
import com.aashiyaana.aashiyaanabackend.exchanges.GetSignUpRequest;
import com.aashiyaana.aashiyaanabackend.exchanges.GetSignUpResponse;
import com.aashiyaana.aashiyaanabackend.services.SignUpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SignUpController {
    public static final String SIGNUP_API = "/signup";

    @Autowired
    private SignUpService signUpService;

    public GetSignUpResponse signUpUser(GetSignUpRequest getSignUpRequest) {
        SignUp newUserSignUp = new SignUp(getSignUpRequest.getUsername(),
                getSignUpRequest.getPassword(),
                getSignUpRequest.getEmail(),
                getSignUpRequest.getMobileNumber());

        GetSignUpResponse response = signUpService.signUpUser(newUserSignUp);
        return response;
    }
}
