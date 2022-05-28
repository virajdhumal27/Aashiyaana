package com.aasihyaana.aashiyaanabackend.services;

import com.aasihyaana.aashiyaanabackend.constants.ActiveUsers;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;
import com.aasihyaana.aashiyaanabackend.repositoryservices.UserRepositoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public PostLoginReponse loginUser(PostLoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Boolean isLoggedIn = userRepositoryService.findLoginUser(username, password);

        if(isLoggedIn) {
            Integer userId = ActiveUsers.addNewActiveUser(username);
            return new PostLoginReponse(Boolean.TRUE, userId, "User Logged In");
        }

        return null;
    }
    
}
