package com.estesting.gateway.data;

import com.estesting.gateway.form.PasswordChangeForm;

public class PasswordChangeFormTestData {
    public static PasswordChangeForm buildValidPasswordChangeForm(String email, String oldPassword) {
        return PasswordChangeForm.builder().email(email).password("!Q@W1q2w1q2w").oldPassword(oldPassword).build();
    }
}
