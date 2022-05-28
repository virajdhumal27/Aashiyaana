package com.aasihyaana.aashiyaanabackend.repositoryservices;

import org.springframework.stereotype.Service;

@Service
public interface UserRepositoryService {
    void findLoginUser(String username, String password);
}
