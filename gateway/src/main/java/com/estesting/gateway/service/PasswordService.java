package com.estesting.gateway.service;

import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.form.PasswordResetForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PasswordService {

    ResponseEntity<String> resetPassword(@Valid PasswordResetForm passwordResetForm);
    ResponseEntity<String> changePassword(@Valid PasswordChangeForm passwordChangeForm);
}
