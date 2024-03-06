package com.mykytaaa.user.profile.service.e2e.steps;

import com.mykytaaa.user.profile.service.e2e.generated.api.UserProfileControllerApi;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsUpdateRequestDto;
import com.mykytaaa.user.profile.service.e2e.util.HttpRequestExceptionResolver;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import com.mykytaaa.user.profile.service.e2e.util.TestContextStorage;
import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateUserDetailsStep {

    private final UserProfileControllerApi userProfileControllerApi;

    @When("a client wants to update its contacts {long} to:")
    public void updateUserDetails(long id, DataTable dataTable) {
        final UserDetailsUpdateRequestDto requestDto = ModelMapper.toUserDetailsUpdateRequestDto(dataTable);

        final var response = HttpRequestExceptionResolver.sendRequest(
                () -> userProfileControllerApi.updateUserDetailsByIdWithHttpInfo(id, requestDto),
                UserProfileOperationType.UPDATE_USER_DETAILS
        );

        TestContextStorage.setContext(response);
    }
}
