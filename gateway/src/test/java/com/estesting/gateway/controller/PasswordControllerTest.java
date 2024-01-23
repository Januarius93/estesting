package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.form.PasswordChangeForm;
import com.estesting.gateway.model.User;
import com.estesting.gateway.repository.UserRepository;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

import static com.estesting.dependencies.commons.Endpoint.*;
import static com.estesting.gateway.data.PasswordChangeFormTestData.buildInvalidOldPasswordPasswordChangeForm;
import static com.estesting.gateway.data.PasswordChangeFormTestData.buildValidPasswordChangeForm;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(PasswordController.class)
public class PasswordControllerTest extends AbstractUnitTest {
    private static final Logger log = LoggerFactory.getLogger(PasswordController.class);

    private static final String PASSWORD_CHANGE = PASSWORD_ENDPOINT + PASSWORD_CHANGE_ENDPOINT;

    @Test
    public void withExistingEmailDataPasswordResetShouldReturnSuccessWithHttp200() {
    }

    @Test
    public void withNonExistentEmailDataPasswordResetShouldReturnSuccessWithHttp400() {
    }

    @Test
    public void withProperOldPasswordDataPasswordChangeShouldReturnSuccessWithHttp200() {
        String TEST_PASSWORD = "$R#E1q2#E1@QE";
        User user = generateUser(TEST_PASSWORD);
        PasswordChangeForm validPasswordChangeForm = buildValidPasswordChangeForm(user.getEmail(), TEST_PASSWORD);
        sendMockedRequest(validPasswordChangeForm, PASSWORD_CHANGE, status().isOk(), "{\"message\":\"Password changed for: " + user.getEmail() + "\","
                + "\"code\":\"OK\"}");
    }

    @Test
    public void withInvalidOldPasswordDataPasswordResetShouldReturnErrorsAndHttp500() {
        String TEST_PASSWORD = "$R#E1q2#E1@QE";
        User user = generateUser(TEST_PASSWORD);
        PasswordChangeForm validPasswordChangeForm = buildInvalidOldPasswordPasswordChangeForm(user.getEmail());
        sendMockedRequest(validPasswordChangeForm, PASSWORD_CHANGE, status().isInternalServerError(), "{\"message\":\"Old password for:  " + user.getEmail() + " is incorrect\","
                + "\"code\":\"INTERNAL_SERVER_ERROR\"}");
    }
}
