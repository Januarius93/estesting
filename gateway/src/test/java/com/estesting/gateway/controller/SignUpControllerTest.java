package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.model.SignUpForm;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SignUpControllerTest extends AbstractUnitTest {

    private SignUpForm signUpForm = new SignUpForm();

    @BeforeTest
    public void setUpBeforeTest(){

    }
    @Test
    public void signupShouldReturnSignUpSuccessWithValidUserDataAndHttp200(){

    }

}
