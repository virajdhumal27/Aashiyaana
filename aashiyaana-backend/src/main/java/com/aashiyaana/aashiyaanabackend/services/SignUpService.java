package com.aashiyaana.aashiyaanabackend.services;

import com.aashiyaana.aashiyaanabackend.dto.SignUp;
import com.aashiyaana.aashiyaanabackend.exchanges.GetSignUpResponse;

public interface SignUpService {

    GetSignUpResponse signUpUser(SignUp signUp);

}
