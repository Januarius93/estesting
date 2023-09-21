package com.estesting.gateway.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.List;

import static com.estesting.dependencies.commons.ErrorCodes.*;
import static com.estesting.gateway.SignInFormTestData.*;
import static com.estesting.gateway.SignUpFormTestData.*;

public class UnitTestDataProvider {

    @DataProvider(name = "invalidSignInForm")
    public Object[][] invalidSignInForm() {
        return new Object[][]{
                {buildEmptyLoginSignInForm(), List.of(LOGIN_CAN_NOT_BE_BLANK, LOGIN_CAN_NOT_BE_EMPTY)},
                {
                        buildNullLoginSignInForm(),
                        List.of(LOGIN_CAN_NOT_BE_EMPTY, LOGIN_CAN_NOT_BE_BLANK, LOGIN_IS_MANDATORY)
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
                                LOGIN_CAN_NOT_BE_EMPTY,
                                LOGIN_CAN_NOT_BE_BLANK,
                                PASSWORD_CAN_NOT_BE_EMPTY,
                                PASSWORD_CAN_NOT_BE_BLANK)
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
                        List.of(THIS_IS_NOT_EMAIL, MUST_BE_A_WELL_FORMED_EMAIL_ADDRESS)
                },
                {
                        buildEmptyEmailSignUpForm(),
                        List.of(EMAIL_CAN_NOT_BE_EMPTY, EMAIL_CAN_NOT_BE_BLANK, THIS_IS_NOT_EMAIL)
                },
                {
                        buildEmptyUserNameSignUpForm(),
                        List.of(USERNAME_CAN_NOT_BE_EMPTY, USERNAME_CAN_NOT_BE_BLANK)
                },
                {
                        buildEmptyPasswordSignUpForm(),
                        List.of(PASSWORD_CAN_NOT_BE_EMPTY, PASSWORD_CAN_NOT_BE_BLANK)
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
                                AGE_CAN_NOT_BE_GREATER_THAN_100)
                },
                {
                        buildAllNullFieldsSignUpForm(),
                        List.of(PASSWORD_CAN_NOT_BE_BLANK,
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
        };
    }
}
