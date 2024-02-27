package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.generated.api.UserProfileControllerApi;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserUpdateRequestDto;
import com.mykytaaa.user.profile.service.e2e.util.HttpRequestExceptionResolver;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserStep {

    /**
     * The API interface for the user profile controller.
     */
    private final UserProfileControllerApi userProfileControllerApi;

    /**
     * Initiates a request to update a user with the specified ID using the provided data.
     *
     * @param id The ID of the user to update.
     * @param dataTable The DataTable containing the updated user information.
     */
    @When("a client wants to update a user with id: {long}")
    public void updateUser(long id, DataTable dataTable) {
        final UserUpdateRequestDto requestDto = ModelMapper.toUserUpdateRequestDto(dataTable);

        final var response = HttpRequestExceptionResolver.sendRequest(
                () -> userProfileControllerApi.updateWithHttpInfo(id, requestDto),
                UserProfileOperationType.UPDATE_USER
        );
        TestContextStorage.setContext(response);
    }
}
