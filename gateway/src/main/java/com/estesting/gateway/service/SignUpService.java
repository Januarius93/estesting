package com.estesting.gateway.service;

import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.model.User;

public interface SignUpService {
    void createUser(SignUpForm signUpForm);
}
