package com.aasihyaana.aashiyaanabackend.repositoryservices.users;

import com.aasihyaana.aashiyaanabackend.dto.User;
import com.aasihyaana.aashiyaanabackend.exceptions.UserNotFoundException;

import org.springframework.stereotype.Service;

/**
 * The {@code UserRepositoryService} interface provides the business logic for finding and loggining the user.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@Service
public interface UserRepositoryService {

    /**
     * Returns a {@code User} object from users table from provided username and password.
     * 
     * @param username Username required to find the user who wants to log in.
     * @return Returns the {@code User} object if present, else null.
     */
    User findLoginUser(String username) throws UserNotFoundException;

    /**
     * Adds the new user to the table.
     * 
     * @param user User required to save in database.
     * @return Returns the {@code User} object after saving in database.
     */
    User signupUser(User newUser);
}
