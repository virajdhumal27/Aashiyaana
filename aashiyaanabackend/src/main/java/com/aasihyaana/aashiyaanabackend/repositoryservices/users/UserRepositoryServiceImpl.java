package com.aasihyaana.aashiyaanabackend.repositoryservices.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasihyaana.aashiyaanabackend.dto.User;
import com.aasihyaana.aashiyaanabackend.entity.UserEntity;
import com.aasihyaana.aashiyaanabackend.repositories.UserRepository;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findLoginUser(String username) {
        UserEntity loginUser = userRepository.findByUsername(username).get(0);

        if(loginUser == null) {
            return null;
        }

        User user = new User();
        user.setUserId(loginUser.getUserId());
        user.setUsername(username);
        user.setPassword(loginUser.getPassword());
        user.setPhoneNumber(loginUser.getPhoneNumber());
        user.setEmail(loginUser.getEmail());

        return user;
    }

    @Override
    public User signupUser(User newUser) {
        UserEntity userEntity = new UserEntity();
        
        userEntity.setUsername(newUser.getUsername());
        userEntity.setPassword(newUser.getPassword());
        userEntity.setEmail(newUser.getEmail());
        userEntity.setPhoneNumber(newUser.getPhoneNumber());

        userRepository.save(userEntity);

        return newUser;
    }
    
}
