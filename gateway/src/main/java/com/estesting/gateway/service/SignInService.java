package com.estesting.gateway.service;

import com.estesting.gateway.form.SignInForm;
import org.springframework.http.ResponseEntity;

public interface SignInService extends Service {

  ResponseEntity<String> signIn(SignInForm signInForm);
}
