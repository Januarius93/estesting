package com.estesting.gateway.controller.signin;

import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.service.SignInService;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class SignInController {
  private static final Logger log = LoggerFactory.getLogger(SignInController.class);
  @Autowired private SignInService signInService;

  @SneakyThrows
  @RequestMapping(value = "/signin", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<Object> signIn(
      @RequestBody @Valid SignInForm signInForm, BindingResult bindingResult) {
    signInService.signIn(signInForm);
    return new ResponseEntity<>("user: " + signInForm.getLogin() + " SignIn", HttpStatus.OK);
  }
}
