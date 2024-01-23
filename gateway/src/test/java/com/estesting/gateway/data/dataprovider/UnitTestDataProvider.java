package com.estesting.gateway.data.dataprovider;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.dependencies.commons.ErrorCodes.Password.*;
import static com.estesting.dependencies.commons.FormRequestAttributes.*;
import static com.estesting.gateway.data.SignInFormTestData.*;
import static com.estesting.gateway.data.SignUpFormTestData.*;
import static com.estesting.gateway.data.SignUpFormTestData.buildAllFieldsSmallerInvalidSizeDataSignUpForm;

import java.util.List;
import org.testng.annotations.DataProvider;

public class UnitTestDataProvider {
  @DataProvider(name = "invalidSignInForm")
  public Object[][] invalidSignInForm() {
    return new Object[][]{
            {
                    buildEmptyLoginSignInForm(),
                    List.of(
                            LOGIN_CAN_NOT_BE_BLANK,
                            LOGIN_CAN_NOT_BE_EMPTY,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
            },
            {
                    buildNullLoginSignInForm(),
                    List.of(
                            LOGIN_CAN_NOT_BE_EMPTY,
                            LOGIN_CAN_NOT_BE_BLANK,
                            LOGIN_IS_MANDATORY,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
            },
            {
                    buildEmptyPasswordSignInForm(),
                    List.of(
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
            },
            {
                    buildNullPasswordSignInForm(),
                    List.of(
                            PASSWORD_IS_MANDATORY,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
            },
            {
                    buildAllEmptyFieldsSignInForm(),
                    List.of(
                            LOGIN_CAN_NOT_BE_EMPTY,
                            LOGIN_CAN_NOT_BE_BLANK,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + LOGIN + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10)
            },
            {
                    buildAllNullFieldsSignInForm(),
                    List.of(
                            LOGIN_CAN_NOT_BE_BLANK,
                            PASSWORD_IS_MANDATORY,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            LOGIN_IS_MANDATORY,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            LOGIN_CAN_NOT_BE_EMPTY)
            },
            {
                    buildNoDataFieldsSignInForm(),
                    List.of(
                            PASSWORD_IS_MANDATORY,
                            LOGIN_CAN_NOT_BE_EMPTY,
                            LOGIN_IS_MANDATORY,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            LOGIN_CAN_NOT_BE_BLANK,
                            PASSWORD_CAN_NOT_BE_BLANK)
            },
    };
  }

  @DataProvider(name = "invalidDataSignUpForm")
  public Object[][] invalidDataSignUpForm() {
    return new Object[][]{
            {
                    buildInvalidEmailFormatSignUpForm(),
                    List.of(
                            THIS_IS_NOT_EMAIL,
                            EMAIL_MUST_BE_WELL_FORMATED,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MINIMUM_NUMBER_OF_CHARACTERS_3)
            },
            {
                    buildEmptyEmailSignUpForm(),
                    List.of(
                            EMAIL_CAN_NOT_BE_EMPTY,
                            EMAIL_CAN_NOT_BE_BLANK,
                            THIS_IS_NOT_EMAIL,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MINIMUM_NUMBER_OF_CHARACTERS_3)
            },
            {
                    buildEmptyUserNameSignUpForm(),
                    List.of(
                            USERNAME_CAN_NOT_BE_EMPTY,
                            USERNAME_CAN_NOT_BE_BLANK,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MINIMUM_NUMBER_OF_CHARACTERS_3)
            },
            {
                    buildEmptyPasswordSignUpForm(),
                    List.of(
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10,
                            PASSWORD_MUST_CONTAINS_NO_WHITESPACE,
                            PASSWORD_MUST_CONTAINS_a_z,
                            PASSWORD_MUST_CONTAINS_A_Z,
                            PASSWORD_MUST_CONTAINS_0_9,
                            PASSWORD_MUST_CONTAINS_SPECIAL_CHARS)
            },
            {buildAgeBelow18SignUpForm(), List.of(AGE_CAN_NOT_BE_SMALLER_THAN_18)},
            {buildAgeAbove100SignUpForm(), List.of(AGE_CAN_NOT_BE_GREATER_THAN_100)},
            {
                    buildAllEmptyFieldsSignUpForm(),
                    List.of(
                            THIS_IS_NOT_EMAIL,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            USERNAME_CAN_NOT_BE_BLANK,
                            EMAIL_CAN_NOT_BE_EMPTY,
                            USERNAME_CAN_NOT_BE_EMPTY,
                            EMAIL_CAN_NOT_BE_BLANK,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            AGE_CAN_NOT_BE_GREATER_THAN_100,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10,
                            PASSWORD_MUST_CONTAINS_NO_WHITESPACE,
                            PASSWORD_MUST_CONTAINS_a_z,
                            PASSWORD_MUST_CONTAINS_A_Z,
                            PASSWORD_MUST_CONTAINS_0_9,
                            PASSWORD_MUST_CONTAINS_SPECIAL_CHARS)
            },
            {
                    buildAllNullFieldsSignUpForm(),
                    List.of(
                            PASSWORD_CAN_NOT_BE_BLANK,
                            USERNAME_CAN_NOT_BE_NULL,
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            USERNAME_CAN_NOT_BE_BLANK,
                            EMAIL_CAN_NOT_BE_EMPTY,
                            PASSWORD_CAN_NOT_BE_NULL,
                            AGE_CAN_NOT_BE_NULL,
                            EMAIL_CAN_NOT_BE_NULL,
                            USERNAME_CAN_NOT_BE_EMPTY,
                            EMAIL_CAN_NOT_BE_BLANK)
            },
            {
                    buildNoDataSignUpForm(),
                    List.of(
                            PASSWORD_CAN_NOT_BE_EMPTY,
                            EMAIL_CAN_NOT_BE_NULL,
                            AGE_CAN_NOT_BE_NULL,
                            PASSWORD_CAN_NOT_BE_BLANK,
                            EMAIL_CAN_NOT_BE_EMPTY,
                            USERNAME_CAN_NOT_BE_EMPTY,
                            EMAIL_CAN_NOT_BE_BLANK,
                            USERNAME_CAN_NOT_BE_NULL,
                            USERNAME_CAN_NOT_BE_BLANK,
                            PASSWORD_CAN_NOT_BE_NULL)
            },
            {
                    buildAllFieldsSmallerInvalidSizeDataSignUpForm(),
                    List.of(
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + PASSWORD + MINIMUM_NUMBER_OF_CHARACTERS_10,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            MINIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MINIMUM_NUMBER_OF_CHARACTERS_3,
                            AGE_CAN_NOT_BE_SMALLER_THAN_18,
                            EMAIL_MUST_BE_WELL_FORMATED,
                            THIS_IS_NOT_EMAIL)
            },
            {
                    buildAllFieldsGreaterInvalidSizeDataSignUpForm(),
                    List.of(
                            MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + EMAIL + MAXIMUM_NUMBER_OF_CHARACTERS_50,
                            MAXIMUM_NUMBER_OF_CHARACTERS_FOR_ + USERNAME + MAXIMUM_NUMBER_OF_CHARACTERS_50,
                            MAXIMUM_NUMBER_OF_CHARACTERS_FOR_
                                    + PASSWORD
                                    + MAXIMUM_NUMBER_OF_CHARACTERS_FOR_PASSWORD,
                            AGE_CAN_NOT_BE_GREATER_THAN_100,
                            EMAIL_MUST_BE_WELL_FORMATED)
            }
    };
  }

  @DataProvider(name = "invalidDataPasswordResetForm")
  public Object[][] invalidDataPasswordResetForm() {
    return new Object[][]{
            {"", List.of(EMAIL_CAN_NOT_BE_EMPTY, THIS_IS_NOT_EMAIL, EMAIL_CAN_NOT_BE_BLANK)},
            {"a", List.of(EMAIL_MUST_BE_WELL_FORMATED, THIS_IS_NOT_EMAIL)},
            {"a@", List.of(EMAIL_MUST_BE_WELL_FORMATED, THIS_IS_NOT_EMAIL)},
            {"a@a", List.of(THIS_IS_NOT_EMAIL)},
            {"a.com", List.of(THIS_IS_NOT_EMAIL, EMAIL_MUST_BE_WELL_FORMATED)},
    };
  }
}
