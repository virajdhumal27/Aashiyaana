package com.aasihyaana.aashiyaanabackend.repositoryservices;

import org.springframework.stereotype.Service;

@Service
public class UserRepositoryServiceDummyImpl implements UserRepositoryService {

    @Override
    public Boolean findLoginUser(String username, String password) {

        return Boolean.TRUE;
    }
    
}
