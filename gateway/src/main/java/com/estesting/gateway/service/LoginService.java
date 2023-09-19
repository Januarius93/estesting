package com.estesting.gateway.service;
import com.estesting.gateway.controller.authentication.Authentication;
import com.estesting.gateway.form.LoginForm;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Authentication authentication = new Authentication();
    public void login(LoginForm loginFrom){
        authentication.authenticateUser(loginFrom);
    }
}
