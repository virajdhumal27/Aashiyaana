package com.aasihyaana.aashiyaanabackend.services;

import com.aasihyaana.aashiyaanabackend.exchanges.PostSignUpRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostSignupResponse;

/**
 * The {@code SignupService} interface handles the processes required for registering the user.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
public interface SignupService {

    /**
     * This method validates the request and registers the user in database.
     * 
     * @param signUpRequest Contains the request required for signinning up the user.
     * @return Returns {@code PostSignupResponse}, containing if user registered or not, 
     * if not registered, an error message is included.
     */
    PostSignupResponse registerUser(PostSignUpRequest signUpRequest);
}
