package com.aasihyaana.aashiyaanabackend.services;

import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignupResponse;

public interface SignupService {
    PostSignupResponse registerUser(PostSignUpRequest signUpRequest);
}
