package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsResponseDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsProfileAbstractDtoAssertion extends AbstractDtoAssertHandler<UserDetailsResponseDto> {

    /**
     * Asserts the equality of the actual user details response with the expected response using SoftAssertions.
     *
     * @param dataTable       The DataTable containing the expected response data.
     * @param actualResponse  The actual user details response obtained from the system under test.
     * @param softly          SoftAssertions object for collecting assertion errors.
     */
    @Override
    public void assertActualResponse(DataTable dataTable,
                                     UserDetailsResponseDto actualResponse,
                                     SoftAssertions softly) {
        final UserDetailsResponseDto expectedResponse = ModelMapper.toUserDetailsResponseDto(dataTable);

        softly.assertThat(actualResponse.getId()).isEqualTo(expectedResponse.getId());
        softly.assertThat(actualResponse.getTelegramId()).isEqualTo(expectedResponse.getTelegramId());
        softly.assertThat(actualResponse.getPhoneNumber()).isEqualTo(expectedResponse.getPhoneNumber());
    }
}
