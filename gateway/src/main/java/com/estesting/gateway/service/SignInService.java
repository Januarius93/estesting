package com.estesting.gateway.service;
import com.estesting.gateway.controller.authentication.Authentication;
import com.estesting.gateway.form.SignInForm;
import org.springframework.stereotype.Service;

@Service
public class SignInService {
    private Authentication authentication = new Authentication();
    public void signIn(SignInForm SignInFrom){
        authentication.authenticateUser(SignInFrom);
    }
}
