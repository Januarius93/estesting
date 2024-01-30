package com.estesting.gateway.service;

import com.estesting.gateway.form.Form;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PasswordService extends Service {

  ResponseEntity<String> resetPassword(@Valid Form passwordResetForm);

  ResponseEntity<String> changePassword(@Valid Form passwordChangeForm);
}
