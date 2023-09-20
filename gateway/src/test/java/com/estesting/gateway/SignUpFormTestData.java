package com.estesting.gateway;

import com.estesting.gateway.form.SignUpForm;

public class SignUpFormTestData {

  public static String buildValidSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(18)
        .build()
        .getSignUpData();
  }

  public static String buildInvalidEmailFormatSignUpForm() {
    return SignUpForm.builder()
        .email("wrongmail")
        .username("someusername")
        .password("somepwd")
        .age(21)
        .build()
        .getSignUpData();
  }

  public static String buildEmptyEmailSignUpForm() {
    return SignUpForm.builder()
        .email("")
        .username("someusername")
        .password("somepwd")
        .age(18)
        .build()
        .getSignUpData();
  }

  public static String buildEmptyUserNameSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("")
        .password("somepwd")
        .age(18)
        .build()
        .getSignUpData();
  }

  public static String buildEmptyPasswordSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("")
        .age(18)
        .build()
        .getSignUpData();
  }

  public static String buildAgeBelow18SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(17)
        .build()
        .getSignUpData();
  }

  public static String buildAgeAbove100SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(101)
        .build()
        .getSignUpData();
  }

  public static String buildAllEmptyFieldsSignUpForm() {
    return SignUpForm.builder()
        .email("")
        .username("")
        .password("")
        .age(101)
        .build()
        .getSignUpData();
  }

  public static String buildAllNullFieldsSignUpForm() {
    return SignUpForm.builder()
        .email(null)
        .username(null)
        .password(null)
        .age(null)
        .build()
        .getSignUpData();
  }

  public static String buildNoDataSignUpForm() {
    return SignUpForm.builder().build().getSignUpData();
  }
}
