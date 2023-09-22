package com.estesting.gateway.form;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PasswordResetFormTest {
    @Test
    public void passwordResetFormCreatedSuccessfully() {
        String somePassword = "some password";
        PasswordResetForm passwordResetForm = new PasswordResetForm();
        passwordResetForm.setPassword(somePassword);

        assertThat(passwordResetForm, is(notNullValue()));
        assertThat(passwordResetForm.getPassword(), equalTo(somePassword));
    }
}
