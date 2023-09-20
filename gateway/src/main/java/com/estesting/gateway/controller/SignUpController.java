package com.estesting.gateway.controller;

import com.estesting.gateway.form.LoginForm;
import com.estesting.gateway.form.SignUpForm;
import jakarta.validation.Valid;
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

    @PostMapping("/signup")
    public @ResponseBody ResponseEntity<Object> signUp(@RequestBody @Valid SignUpForm signUpForm, BindingResult bindingResult){
        return new ResponseEntity<>("user: " + signUpForm.getLogin() + " login", HttpStatus.OK);
    }
}
