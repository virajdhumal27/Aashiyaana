package com.aasihyaana.aashiyaanabackend.services.signupservice;

import com.aasihyaana.aashiyaanabackend.dto.User;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignupResponse;
import com.aasihyaana.aashiyaanabackend.repositoryservices.users.UserRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public PostSignupResponse registerUser(PostSignUpRequest signUpRequest) {
        User newUser = new User();

        newUser.setUsername(signUpRequest.getUsername());
        newUser.setPassword(signUpRequest.getPassword());
        newUser.setPhoneNumber(signUpRequest.getPhoneNumber());
        newUser.setEmail(signUpRequest.getEmail());

        userRepositoryService.signupUser(newUser);
        return new PostSignupResponse(Boolean.TRUE, "Signup Success");
    }
    
}
