package com.aasihyaana.aashiyaanabackend.repositoryservices.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aasihyaana.aashiyaanabackend.dto.User;
import com.aasihyaana.aashiyaanabackend.entity.UserEntity;
import com.aasihyaana.aashiyaanabackend.exceptions.UserNotFoundException;
import com.aasihyaana.aashiyaanabackend.repositories.UserRepository;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findLoginUser(String username) throws UserNotFoundException {
        List<UserEntity> usersList = userRepository.findByUsername(username);
        if(usersList == null || usersList.size() == 0) {
            throw new UserNotFoundException("User not Found!");
        }
        UserEntity loginUser = usersList.get(0);

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
