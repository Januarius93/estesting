package com.estesting.gateway.controller;

import static com.estesting.dependencies.commons.Endpoint.SIGN_UP_ENDPOINT;
import static com.estesting.dependencies.commons.Endpoint.USER_ENDPOINT;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatResponseContainsErrorCodes;
import static com.estesting.gateway.assertion.UnitTestAssertion.assertThatStatusCodeIs400;
import static com.estesting.gateway.data.SignUpFormTestData.buildValidSignUpForm;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.estesting.gateway.AbstractUnitTest;
import com.estesting.gateway.controller.signup.SignUpController;
import com.estesting.gateway.data.dataprovider.UnitTestDataProvider;
import com.estesting.gateway.form.SignUpForm;

import java.util.List;

import lombok.SneakyThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.testng.annotations.Test;

@SpringBootTest
@Import(SignUpController.class)
public class SignUpControllerTest extends AbstractUnitTest {
    @Test
    @SneakyThrows
    public void withValidSignUpDataSignupShouldReturnSuccessAndHttp200() {
        SignUpForm validSignupForm = buildValidSignUpForm();
        sendMockedPutRequest(validSignupForm, USER_ENDPOINT+SIGN_UP_ENDPOINT, status().isOk(),
                "User: someusername created");
    }

    @SneakyThrows
    @Test(dataProvider = "invalidDataSignUpForm", dataProviderClass = UnitTestDataProvider.class)
    public void withInvalidSignupDataShouldReturnErrorsAnd400(
            SignUpForm signUpFormData, List<String> errorCodes) {
        MvcResult mvcResult = sendMockedPutRequestAndReturn(signUpFormData, USER_ENDPOINT+SIGN_UP_ENDPOINT);
        assertThatStatusCodeIs400(mvcResult);
        assertThatResponseContainsErrorCodes(mvcResult, errorCodes);
    }
}
