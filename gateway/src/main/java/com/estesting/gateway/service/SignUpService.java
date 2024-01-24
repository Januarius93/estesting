package com.estesting.gateway.service;

import com.estesting.gateway.form.SignUpForm;
import org.springframework.http.ResponseEntity;

public interface SignUpService extends Service {

  ResponseEntity<String> createUser(SignUpForm signUpForm);
}
