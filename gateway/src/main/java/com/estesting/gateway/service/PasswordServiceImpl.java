package com.estesting.gateway.service;

import com.estesting.gateway.form.PasswordResetForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImpl implements PasswordService {
  public ResponseEntity<String> resetPassword(@Valid PasswordResetForm passwordResetForm) {
    return null;
  }
}
