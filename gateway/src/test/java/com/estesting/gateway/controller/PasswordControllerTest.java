package com.estesting.gateway.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(PasswordController.class)
public class PasswordControllerTest {

}
