package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.generated.api.UserProfileControllerApi;
import com.mykytaaa.user.profile.service.e2e.util.HttpRequestExceptionResolver;
import com.mykytaaa.user.profile.service.e2e.util.TestContext;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindUserDetailsByIdStep {

    /**
     * The API interface for the user profile controller operations.
     */
    private final UserProfileControllerApi controllerApi;

    /**
     * Initiates a request to find user details by the specified ID.
     *
     * @param id The ID of the user whose details are to be retrieved.
     */
    @When("a client wants to find its contacts with id: {long}")
    public void findUserById(long id) {
        final TestContext response = HttpRequestExceptionResolver.sendRequest(
                () -> controllerApi.findUserDetailsByIdWithHttpInfo(id),
                UserProfileOperationType.FIND_USER_DETAILS_BY_ID
        );
        TestContextStorage.setContext(response);
    }
}
