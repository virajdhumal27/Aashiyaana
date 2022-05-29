package com.aasihyaana.aashiyaanabackend.controller.login;

import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginReponse;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLoginRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutRequest;
import com.aasihyaana.aashiyaanabackend.exchanges.PostLogoutResponse;
import com.aasihyaana.aashiyaanabackend.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The {@code LoginController} class handles the login and logout {@code POST} 
 * requests and sends appropriate response recieved from service class.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(LoginController.LOGIN_ENDPOINT_API)
public class LoginController {
    public static final String LOGIN_ENDPOINT_API = "/login";
    public static final String LOGIN_API = "/loginUser";
    public static final String LOGOUT_API = "/logoutUser";

    @Autowired
    private LoginService loginService;

    @PostMapping(LOGIN_API)
    public PostLoginReponse checkUser(@RequestBody PostLoginRequest loginRequest) {
        System.out.println(loginRequest.getUsername() + " " + loginRequest.getPassword());
        return loginService.loginUser(loginRequest);
    }

    public PostLogoutResponse logoutUser(@RequestBody PostLogoutRequest logoutRequest) {
        return null;
    }
}
