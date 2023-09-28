package com.estesting.gateway.service;

import com.estesting.gateway.form.Form;
import com.estesting.gateway.form.SignUpForm;
import org.springframework.http.ResponseEntity;

public interface SignUpService {
  ResponseEntity<String> createUser(SignUpForm signUpForm);
}
