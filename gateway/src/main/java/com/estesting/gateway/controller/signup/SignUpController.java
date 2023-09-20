package com.estesting.gateway.controller.signup;

import com.estesting.gateway.form.SignUpForm;
import com.estesting.gateway.service.LoginService;
import com.estesting.gateway.service.SignUpService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class SignUpController {
  private static final Logger log = LoggerFactory.getLogger(SignUpController.class);
  @Autowired private SignUpService signUpService;

  @SneakyThrows
  @PostMapping("/signup")
  public @ResponseBody ResponseEntity<Object> signUp(
      @RequestBody @Valid SignUpForm signUpForm, BindingResult bindingResult) {
    signUpService.signUp(signUpForm);
    log.info("user: " + signUpForm.getSignUpData() + " singup");

    return new ResponseEntity<>("user: " + signUpForm.getSignUpData() + " singup", HttpStatus.OK);
  }
}