package com.aasihyaana.aashiyaanabackend.controller.signup;

import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignupResponse;
import com.aasihyaana.aashiyaanabackend.services.signupservice.SignupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code SignupController} class handles requests related to siginning up a new user.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(SignupController.SIGNUP_ENDPOINT_API)
public class SignupController {
    public static final String SIGNUP_ENDPOINT_API = "signup";
    public static final String SIGNUP_API = "signupUser";

    @Autowired
    private SignupService signupService;
    
    @PostMapping(SIGNUP_API)
    public PostSignupResponse signupUser(@RequestBody PostSignUpRequest signUpRequest) {
        return signupService.registerUser(signUpRequest);
    }

}
