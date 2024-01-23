package com.estesting.gateway.data;

import com.estesting.gateway.form.SignUpForm;

import static com.estesting.gateway.data.DataRandomizer.generateUserEmailWithSoftRandom;
import static com.estesting.gateway.data.DataRandomizer.generateUserNameWithSoftRandom;

public class SignUpFormTestData {

  public static SignUpForm buildValidSignUpFormWithPassword(String password) {
    return SignUpForm.builder()
            .email(generateUserEmailWithSoftRandom())
            .username(generateUserNameWithSoftRandom())
            .password(password)
            .age(18)
            .build();
  }
  public static SignUpForm buildValidSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("1q2w!Q@W2w1q@W!Q")
        .age(18)
        .build();
  }

  public static SignUpForm buildOtherValidSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermailother@mail.com")
        .username("someusernameother")
        .password("someusernamepwd")
        .age(18)
        .build();
  }

  public static SignUpForm buildInvalidEmailFormatSignUpForm() {
    return SignUpForm.builder()
        .email("a.")
        .username("someusername")
        .password("qAwe7rty!uiop")
        .age(21)
        .build();
  }

  public static SignUpForm buildEmptyEmailSignUpForm() {
    return SignUpForm.builder()
        .email("")
        .username("someusername")
        .password("qAwe7rty!uiop")
        .age(18)
        .build();
  }

  public static SignUpForm buildEmptyUserNameSignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("")
        .password("qAwe7rty!uiop")
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
        .password("qAwe7rty!uiop")
        .age(17)
        .build();
  }

  public static SignUpForm buildAgeAbove100SignUpForm() {
    return SignUpForm.builder()
        .email("somepropermail@mail.com")
        .username("someusername")
        .password("qAwe7rty!uiop")
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

  public static SignUpForm buildAllFieldsSmallerInvalidSizeDataSignUpForm() {
    return SignUpForm.builder()
        .email("a@")
        .username("dow")
        .password("o1q2w!Q@W")
        .age(17)
        .build();
  }

  public static SignUpForm buildAllFieldsGreaterInvalidSizeDataSignUpForm() {
    return SignUpForm.builder()
        .email(
            "somepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermailsomepropermail@mail.com")
        .username(
            "    \"pcpdqiqwkdzvxuvlaiurlwodysskyweznqxczjucyjxzpgqtaix\\n\"\n"
                + "                + \"zgccllkitapgknujfpkijhgvkjrkhkjpvoefivpvgoztkxxuxke\\n\"\n"
                + "                + \"nihywrklocubigvoidniczwzkcxbelnwdehytzujmflwfjccxsh\\n\"\n"
                + "                + \"agfwvmxbecvhjvrzlijnmorxkzbqhghbtxwfgkagijhsauyqxaj\\n\"\n"
                + "                + \"pezfpohldpulgaueppxdfligucpgplwufurvgazoxtuwelbukch\"")
        .password("1q2w1qQAWS" +
                "!@#qaynumgjnnazkuhempmwlwqpmbonaasslpuycphpijnbmeybfsefsefsefsefsefsefseziolruzrugznekcafafrmgnlkiwxuwwuogsgbtqclkpjxmebnyhksawgpmpwpzecsvqopjansawopfhiqlazrobgtqgabacpxrnkbxzemfdhfxnlxbcyobyfxcgatlultqlwmizwc")

        .age(101)
        .build();
  }
}
