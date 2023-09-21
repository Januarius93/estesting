package com.estesting.gateway.controller;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signin.SignInController;
import com.estesting.gateway.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.SignInForm;
import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.testng.annotations.Test;

import java.util.List;

import static com.estesting.gateway.SignInFormTestData.buildValidSignInForm;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatResponseContainsErrorCodes;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatStatusCodeIs400;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Import(SignInController.class)
public class SignInControllerTest extends AbstractUnitTest {
    @Test
    public void withValidSignInDataSignInShouldReturnSuccessWithHttp200() throws Exception {
        SignInForm validSignInForm = buildValidSignInForm();
        mockMvc
                .perform(
                        post(SIGN_IN_ENDPOINT)
                                .content(validSignInForm.getFormData())
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(
                        content()
                                .string(
                                        containsString(
                                                String.format("user: %s SignIn", validSignInForm.getFormData()))))
                .andReturn();
    }

    @SneakyThrows
    @Test(dataProvider = "invalidSignInForm", dataProviderClass = UnitTestDataProvider.class)
    public void withInvalidSignInDataSignInShouldReturnErrorsAndHttp400(
            SignInForm signInForm, List<String> errorCodes) {
        mvcResult =
                mockMvc
                        .perform(
                                post(SIGN_IN_ENDPOINT)
                                        .content(signInForm.getFormData())
                                        .contentType(MediaType.APPLICATION_JSON))
                        .andReturn();
        assertThatStatusCodeIs400(mvcResult);
        assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
    }
}
