package com.aasihyaana.aashiyaanabackend.services.loginservice;

import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutResponse;

/**
 * The {@code LoginService} interface provides methods to login and logout a user.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
public interface LoginService {

    /**
     * Logins the user and maintains the session for that user.
     * 
     * @param loginRequest Contains login and password required to login
     * @return Returns true if login is successful, else false and a error message.
     */
    PostLoginReponse loginUser(PostLoginRequest loginRequest);

    /**
     * Log out the user and ends the session for that user.
     * 
     * @param logoutRequest Contains the User Id of user logged in to terminate session.
     * @return Returns true if logout was successfull, else false.
     */
    PostLogoutResponse logoutUser(PostLogoutRequest logoutRequest);
}
