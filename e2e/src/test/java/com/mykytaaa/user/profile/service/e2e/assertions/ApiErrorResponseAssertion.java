package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.ApiErrorDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiErrorResponseAssertion extends AbstractDtoAssertHandler<ApiErrorDto> {

    /**
     * Asserts the equality of the actual API error response with the expected response using SoftAssertions.
     *
     * @param dataTable       The DataTable containing the expected response data.
     * @param actualResponse  The actual API error response obtained from the system under test.
     * @param softly          SoftAssertions object for collecting assertion errors.
     */
    @Override
    public void assertActualResponse(DataTable dataTable, ApiErrorDto actualResponse, SoftAssertions softly) {
        final ApiErrorDto expectedResponse = ModelMapper.toApiErrorDto(dataTable);

        final List<String> expectedDetailsList = expectedResponse.getDetails();
        final String[] expectedDetails =
                expectedDetailsList != null ? expectedDetailsList.toArray(new String[0]) : new String[0];

        softly.assertThat(actualResponse.getStatus()).isEqualTo(expectedResponse.getStatus());
        softly.assertThat(actualResponse.getMessage()).isEqualTo(expectedResponse.getMessage());
        softly.assertThat(actualResponse.getDetails()).containsExactlyInAnyOrder(expectedDetails);
    }
}
