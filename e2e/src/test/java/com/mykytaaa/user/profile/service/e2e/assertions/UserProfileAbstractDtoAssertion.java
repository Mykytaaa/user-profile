package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.UserResponseDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class UserProfileAbstractDtoAssertion extends AbstractDtoAssertHandler<UserResponseDto> {

    /**
     * Asserts the equality of the actual user response with the expected response using SoftAssertions.
     *
     * @param dataTable       The DataTable containing the expected response data.
     * @param actualResponse  The actual user response obtained from the system under test.
     * @param softly          SoftAssertions object for collecting assertion errors.
     */
    @Override
    public void assertActualResponse(DataTable dataTable, UserResponseDto actualResponse, SoftAssertions softly) {
        final UserResponseDto expectedResponse = ModelMapper.toResponseDto(dataTable);

        softly.assertThat(actualResponse.getId()).isEqualTo(expectedResponse.getId());
        softly.assertThat(actualResponse.getFirstName()).isEqualTo(expectedResponse.getFirstName());
        softly.assertThat(actualResponse.getLastName()).isEqualTo(expectedResponse.getLastName());
        softly.assertThat(actualResponse.getEmail()).isEqualTo(expectedResponse.getEmail());
        softly.assertThat(actualResponse.getUserDetailsResponseDto().getId())
                .isEqualTo(expectedResponse.getUserDetailsResponseDto().getId());
        softly.assertThat(actualResponse.getUserDetailsResponseDto().getPhoneNumber())
                .isEqualTo(expectedResponse.getUserDetailsResponseDto().getPhoneNumber());
        softly.assertThat(actualResponse.getUserDetailsResponseDto().getTelegramId())
                .isEqualTo(expectedResponse.getUserDetailsResponseDto().getTelegramId());
    }
}
