package com.estesting.gateway.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.List;

import static com.estesting.gateway.SignInFormTestData.*;
import static com.estesting.gateway.SignUpFormTestData.*;
import static com.estesting.gateway.constant.ErrorCodes.*;

public class UnitTestDataProvider {

  @DataProvider(name = "invalidSignInForm")
  public Object[][] invalidSignInForm() {
    return new Object[][] {
      {buildEmptyLoginSignInForm(), List.of(EMAIL_CAN_NOT_BE_BLANK, EMAIL_CAN_NOT_BE_EMPTY)},
      {
        buildNullLoginSignInForm(),
        List.of(EMAIL_CAN_NOT_BE_EMPTY, EMAIL_CAN_NOT_BE_BLANK, EMAIL_IS_MANDATORY)
      },
      {
        buildEmptyPasswordSignInForm(),
        List.of(PASSWORD_CAN_NOT_BE_EMPTY, PASSWORD_CAN_NOT_BE_BLANK)
      },
      {
        buildNullPasswordSignInForm(),
        List.of(PASSWORD_IS_MANDATORY, PASSWORD_CAN_NOT_BE_EMPTY, PASSWORD_CAN_NOT_BE_BLANK)
      },
      {
        buildAllEmptyFieldsSignInForm(),
        List.of(
            EMAIL_CAN_NOT_BE_EMPTY,
            EMAIL_CAN_NOT_BE_BLANK,
            PASSWORD_CAN_NOT_BE_EMPTY,
            PASSWORD_CAN_NOT_BE_BLANK)
      },
      {
        buildAllNullFieldsSignInForm(),
        List.of(
            EMAIL_CAN_NOT_BE_BLANK,
            PASSWORD_IS_MANDATORY,
            PASSWORD_CAN_NOT_BE_BLANK,
            EMAIL_IS_MANDATORY,
            PASSWORD_CAN_NOT_BE_EMPTY,
            EMAIL_CAN_NOT_BE_EMPTY)
      },
      {
        buildNoDataFieldsSignInForm(),
        List.of(
            PASSWORD_IS_MANDATORY,
            EMAIL_CAN_NOT_BE_EMPTY,
            EMAIL_IS_MANDATORY,
            PASSWORD_CAN_NOT_BE_EMPTY,
            EMAIL_CAN_NOT_BE_BLANK,
            PASSWORD_CAN_NOT_BE_BLANK)
      },
    };
  }

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
