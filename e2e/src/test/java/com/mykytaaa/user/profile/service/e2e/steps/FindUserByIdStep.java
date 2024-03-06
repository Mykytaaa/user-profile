package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.generated.api.UserProfileControllerApi;
import com.mykytaaa.user.profile.service.e2e.util.HttpRequestExceptionResolver;
import com.mykytaaa.user.profile.service.e2e.util.TestContext;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindUserByIdStep {

    private final UserProfileControllerApi controllerApi;

    @When("a client wants to find a user with id: {long}")
    public void findUserById(long id) {
        final TestContext response = HttpRequestExceptionResolver.sendRequest(
                () -> controllerApi.findByIdWithHttpInfo(id),
                UserProfileOperationType.FIND_BY_ID
        );
        TestContextStorage.setContext(response);
    }
}
