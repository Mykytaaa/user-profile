package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.UserResponseDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class UserProfileAbstractDtoCreateAssertion extends AbstractDtoAssertHandler<UserResponseDto> {

    /**
     * Asserts the equality of actual user response against expected data from a DataTable.
     *
     * @param dataTable The data table containing expected user information.
     * @param actualResponse The actual response DTO to be verified.
     * @param softly An instance of SoftAssertions for performing assertions without immediately throwing exceptions.
     */
    @Override
    public void assertActualResponse(DataTable dataTable, UserResponseDto actualResponse, SoftAssertions softly) {
        final UserResponseDto expectedResponse = ModelMapper.toCreateResponseDto(dataTable);

        softly.assertThat(actualResponse.getFirstName()).isEqualTo(expectedResponse.getFirstName());
        softly.assertThat(actualResponse.getLastName()).isEqualTo(expectedResponse.getLastName());
        softly.assertThat(actualResponse.getEmail()).isEqualTo(expectedResponse.getEmail());
        softly.assertThat(actualResponse.getUserDetailsResponseDto().getPhoneNumber())
                .isEqualTo(expectedResponse.getUserDetailsResponseDto().getPhoneNumber());
        softly.assertThat(actualResponse.getUserDetailsResponseDto().getTelegramId())
                .isEqualTo(expectedResponse.getUserDetailsResponseDto().getTelegramId());
    }
}
