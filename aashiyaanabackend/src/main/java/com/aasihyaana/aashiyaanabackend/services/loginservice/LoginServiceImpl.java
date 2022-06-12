package com.aasihyaana.aashiyaanabackend.services.loginservice;

import com.aasihyaana.aashiyaanabackend.constants.ActiveUsers;
import com.aasihyaana.aashiyaanabackend.dto.User;
import com.aasihyaana.aashiyaanabackend.exceptions.UserNotFoundException;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutResponse;
import com.aasihyaana.aashiyaanabackend.repositoryservices.users.UserRepositoryService;

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

        
        try {
            User user = userRepositoryService.findLoginUser(username);

            if(!password.equals(user.getPassword())) {
                return new PostLoginReponse(Boolean.FALSE, -1, "Password is incorrect!");
            }
            
            Integer userId = ActiveUsers.addNewActiveUser(user.getUserId(), username);
            return new PostLoginReponse(Boolean.TRUE, userId, "User Logged In!");
            
        } catch (UserNotFoundException e) {
            return new PostLoginReponse(Boolean.FALSE, -1, e.getMessage());
        }

    }

    @Override
    public PostLogoutResponse logoutUser(PostLogoutRequest logoutRequest) {
        Integer userId = logoutRequest.getUserId();

        ActiveUsers.removeActiveUser(userId);

        return new PostLogoutResponse(Boolean.TRUE, "Logout Successful!");
    }
    
}
