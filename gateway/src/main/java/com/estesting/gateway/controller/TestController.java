package com.estesting.gateway.controller;

import com.estesting.gateway.form.SignInForm;
import com.estesting.gateway.model.Message;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.estesting.dependencies.commons.Endpoint.USER_ENDPOINT;

@Validated
@RestController
public class TestController {

    @SneakyThrows
    @GetMapping(value = "/inside")
    public ResponseEntity<String> getUser() {

        return new ResponseEntity(
                new Message(HttpStatus.OK, "INSIDE")
                        .getResponseMessage(),
                HttpStatus.OK);
    }

    @SneakyThrows
    @PostMapping(value = "/some")
    public ResponseEntity<String> some() {

        return new ResponseEntity(
                new Message(HttpStatus.OK, "SOMEINSIDE")
                        .getResponseMessage(),
                HttpStatus.OK);
    }
}
