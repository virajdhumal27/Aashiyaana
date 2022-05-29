package com.aasihyaana.aashiyaanabackend.repositoryservices;

import com.aasihyaana.aashiyaanabackend.dto.User;

import org.springframework.stereotype.Service;

@Service
public class UserRepositoryServiceDummyImpl implements UserRepositoryService {

    @Override
    public User findLoginUser(String username, String password) {

        return null;
    }
    
}
