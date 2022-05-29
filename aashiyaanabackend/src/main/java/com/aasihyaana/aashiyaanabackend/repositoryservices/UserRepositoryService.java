package com.aasihyaana.aashiyaanabackend.repositoryservices;

import com.aasihyaana.aashiyaanabackend.dto.User;

import org.springframework.stereotype.Service;

@Service
public interface UserRepositoryService {
    User findLoginUser(String username, String password);
}
