package com.estesting.gateway.service;

import com.estesting.gateway.form.Form;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.form.PasswordResetForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PasswordService extends Service {

    ResponseEntity<String> resetPassword(@Valid Form passwordResetForm);
    ResponseEntity<String> changePassword(@Valid Form passwordChangeForm);
}
