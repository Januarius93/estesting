package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.form.PasswordResetForm;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import static com.estesting.dependencies.commons.Endpoint.PASSWORD_RESET_ENDPOINT;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(PasswordResetController.class)
public class PasswordResetControllerTest extends AbstractUnitTest {
    @Test
    public void withValidEmailPasswordResetShouldReturnSuccessWithHttp200() throws Exception {
        PasswordResetForm passwordResetForm = new PasswordResetForm();
        passwordResetForm.setEmail("some@mail.com");
        mockMvc.perform(post(PASSWORD_RESET_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(passwordResetForm.getFormData()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(passwordResetForm.getFormData() + " user:  RESET")))
                .andReturn();
    }
}
