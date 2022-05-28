package com.aasihyaana.aashiyaanabackend.services;

import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;

public interface LoginService {
    PostLoginReponse loginUser(PostLoginRequest loginRequest);
}
