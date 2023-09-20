package com.estesting.gateway;

import com.estesting.gateway.form.SignUpForm;

public class SignUpFormTestData {

  public static SignUpForm buildValidSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildInvalidEmailFormatSignUpForm() {
    return SignUpForm.builder()
        .email("wrongmail")
        .username("someusername")
        .password("somepwd")
        .age(21)
        .build();
  }

  public static SignUpForm buildEmptyEmailSignUpForm() {
    return SignUpForm.builder()
        .email("")
        .username("someusername")
        .password("somepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildEmptyUserNameSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("")
        .password("somepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildEmptyPasswordSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("")
        .age(18)
        .build();
  }

  public static SignUpForm buildAgeBelow18SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(17)
        .build();
  }

  public static SignUpForm buildAgeAbove100SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("somepwd")
        .age(101)
        .build();
  }

  public static SignUpForm buildAllEmptyFieldsSignUpForm() {
    return SignUpForm.builder().email("").username("").password("").age(101).build();
  }

  public static SignUpForm buildAllNullFieldsSignUpForm() {
    return SignUpForm.builder().email(null).username(null).password(null).age(null).build();
  }

  public static SignUpForm buildNoDataSignUpForm() {
    return SignUpForm.builder().build();
  }
}
