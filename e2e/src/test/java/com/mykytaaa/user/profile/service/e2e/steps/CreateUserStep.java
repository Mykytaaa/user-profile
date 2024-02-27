package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.generated.api.UserProfileControllerApi;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserCreateRequestDto;
import com.mykytaaa.user.profile.service.e2e.util.HttpRequestExceptionResolver;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserStep {

    /**
     * API interface for user profile controller operations.
     */
    private final UserProfileControllerApi controllerApi;

    /**
     * Initiates the creation of a user with mandatory parameters specified in a DataTable.
     *
     * @param dataTable The data table containing the mandatory parameters for user creation.
     */
    @When("a client wants to create a user with mandatory parameters:")
    public void createUser(DataTable dataTable) {
        final UserCreateRequestDto requestDto = ModelMapper.toUserCreateRequestDto(dataTable);

        final var response = HttpRequestExceptionResolver.sendRequest(
                () -> controllerApi.createUserWithHttpInfo(requestDto),
                UserProfileOperationType.CREATE_USER
        );
        TestContextStorage.setContext(response);
    }
}
