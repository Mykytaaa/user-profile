package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.assertions.FactoryDtoAssertHandler;
import com.mykytaaa.user.profile.service.e2e.util.TestContext;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class HttpResponseStep {

    private final FactoryDtoAssertHandler factoryDtoAssertHandler;

    @Then("response code is {int}")
    public void responseCodeIs(int expectedStatusCode) {
        int actualStatusCode = TestContextStorage.getTestContext().getStatusCode();
        assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

    @And("response body contains:")
    public void responseBodyContains(DataTable dataTable) {
        final TestContext responseContext = TestContextStorage.getTestContext();
        final Object responseBody = responseContext.response().getBody();

        factoryDtoAssertHandler.getInstance(responseContext.operation())
                .assertResponseBody(dataTable, responseBody);

        TestContextStorage.clearContext();
    }
}
