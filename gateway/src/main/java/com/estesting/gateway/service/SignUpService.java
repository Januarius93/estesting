package com.estesting.gateway.service;

import com.estesting.gateway.form.Form;
import org.springframework.http.ResponseEntity;

public interface SignUpService {
  ResponseEntity<String> createUser(Form signUpForm);
}
