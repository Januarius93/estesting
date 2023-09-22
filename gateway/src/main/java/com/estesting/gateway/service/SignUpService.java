package com.estesting.gateway.service;

import com.estesting.gateway.controller.authentication.Authentication;
import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {
    private Authentication authentication = new Authentication();
    @Autowired
    private UserRepository userRepository;

    public void signUp(SignUpForm signUpForm) {
        userRepository.save(new User());
        authentication.authenticateUser(signUpForm);
    }
}
