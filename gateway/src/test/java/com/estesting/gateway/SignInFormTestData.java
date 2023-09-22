package com.estesting.gateway;

import com.estesting.gateway.form.SignInForm;

public class SignInFormTestData {

    public static SignInForm buildValidSignInForm() {
        return SignInForm.builder().login("Joshua").password("somepwd").build();
    }

    public static SignInForm buildEmptyLoginSignInForm() {
        return SignInForm.builder().login("").password("somepwd").build();
    }

    public static SignInForm buildNullLoginSignInForm() {
        return SignInForm.builder().login(null).password("somepwd").build();
    }

    public static SignInForm buildEmptyPasswordSignInForm() {
        return SignInForm.builder().login("somelogin").password("").build();
    }

    public static SignInForm buildNullPasswordSignInForm() {
        return SignInForm.builder().login("somelogin").password(null).build();
    }

    public static SignInForm buildAllEmptyFieldsSignInForm() {
        return SignInForm.builder().login("").password("").build();
    }

    public static SignInForm buildAllNullFieldsSignInForm() {
        return SignInForm.builder().login(null).password(null).build();
    }

    public static SignInForm buildNoDataFieldsSignInForm() {
        return SignInForm.builder().build();
    }
}