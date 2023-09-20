package com.estesting.gateway.service;

import com.estesting.gateway.controller.authentication.Authentication;
import com.estesting.gateway.form.SignUpForm;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private Authentication authentication = new Authentication();

    public void signUp(SignUpForm signUpForm){
        authentication.authenticateUser(signUpForm);
    }
}
