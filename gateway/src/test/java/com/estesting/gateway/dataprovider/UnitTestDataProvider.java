package com.estesting.gateway.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.List;

import static com.estesting.gateway.SignUpFormTestData.*;

public class UnitTestDataProvider {

  @DataProvider(name = "invalidDataSignUpForm")
  public Object[][] invalidDataSignUpForm() {
    return new Object[][] {
      {
        buildInvalidEmailFormatSignUpForm(),
        List.of("This is not email", "must be a well-formed email address")
      },
      {
        buildEmptyEmailSignUpForm(),
        List.of("Email can not be empty", "Email can not be blank", "This is not email")
      },
      {
        buildEmptyUserNameSignUpForm(),
        List.of("Username can not be empty", "Username can not be blank")
      },
      {
        buildEmptyPasswordSignUpForm(),
        List.of("Password can not be empty", "Password can not be blank")
      },
      {buildAgeBelow18SignUpForm(), List.of("Age can not be smaller that 18")},
      {buildAgeAbove100SignUpForm(), List.of("Age can not be greater that 100")},
      {
        buildAllEmptyFieldsSignUpForm(),
        List.of(
            "This is not email",
            "Password can not be empty",
            "Username can not be blank",
            "Email can not be empty",
            "Username can not be empty",
            "Email can not be blank",
            "Password can not be blank",
            "Age can not be greater that 100")
      },
      {
        buildAllNullFieldsSignUpForm(),
        List.of(
            "Username can not be null",
            "Password can not be empty",
            "Username can not be blank",
            "Email can not be empty",
            "Password can not be null",
            "Age can not be null",
            "Email can not be null",
            "Username can not be empty",
            "Email can not be blank")
      },
      {
        buildNoDataSignUpForm(),
        List.of(
            "Password can not be empty",
            "Email can not be null",
            "Age can not be null",
            "Password can not be blank",
            "Email can not be empty",
            "Username can not be empty",
            "Email can not be blank",
            "Username can not be null",
            "Username can not be blank",
            "Password can not be null")
      },
    };
  }
}
