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

    private final UserProfileControllerApi userProfileControllerApi;

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
