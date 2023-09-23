package com.estesting.gateway.service;

import com.estesting.gateway.form.PasswordResetForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
  public void resetPassword(@Valid PasswordResetForm passwordResetForm) {}
}
