package com.aasihyaana.aashiyaanabackend.services;

import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignupResponse;

import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {

    @Override
    public PostSignupResponse registerUser(PostSignUpRequest signUpRequest) {
        return new PostSignupResponse(Boolean.TRUE, "Signup Success");
    }
    
}
