package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.ApiErrorDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class ApiErrorResponseAssertion extends DtoAssertHandler<ApiErrorDto> {
    @Override
    public void assertActualResponse(DataTable dataTable, ApiErrorDto actualResponse, SoftAssertions softly) {
        ApiErrorDto expectedResponse = ModelMapper.toApiErrorDto(dataTable);

        softly.assertThat(actualResponse.getStatus()).isEqualTo(expectedResponse.getStatus());
        softly.assertThat(actualResponse.getMessage()).isEqualTo(expectedResponse.getMessage());
        softly.assertThat(actualResponse.getDetails()).isEqualTo(expectedResponse.getDetails());
    }
}
