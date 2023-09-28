package com.estesting.gateway.controller;

import static com.estesting.dependencies.commons.Endpoint.PASSWORD_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.PASSWORD_RESET_ENDPOINT;

import com.estesting.gateway.form.PasswordResetForm;
import com.estesting.gateway.service.PasswordServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(PASSWORD_ENDPOINT)
public class PasswordController {
  private static final Logger log = LoggerFactory.getLogger(PasswordController.class);
  @Autowired private PasswordServiceImpl passwordServiceImpl;

  @SneakyThrows
  @PostMapping(value = PASSWORD_RESET_ENDPOINT, consumes = "application/json")
  public @ResponseBody ResponseEntity<String> resetPassword(
      @RequestBody @Valid PasswordResetForm passwordResetForm,
      BindingResult bindingResult) {
    log.info("user: "+ passwordResetForm.getEmail()+" RESET");
    return passwordServiceImpl.resetPassword(passwordResetForm);
  }
}
