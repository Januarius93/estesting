package com.estesting.gateway.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.List;

import static com.estesting.gateway.SignUpFormTestData.buildEmptyEmailSignUpForm;
import static com.estesting.gateway.SignUpFormTestData.buildInvalidEmailFormatSignUpForm;

public class UnitTestDataProvider {

  @DataProvider(name = "invalidMailSignUpForm")
  public Object[][] invalidMailSignUpForm() {
    return new Object[][] {
      {
        buildInvalidEmailFormatSignUpForm(),
        List.of("This is not email", "must be a well-formed email address")
      },
      {
        buildEmptyEmailSignUpForm(),
        List.of("Email can not be empty", "Email can not be blank", "This is not email")
      }
    };
  }
}
