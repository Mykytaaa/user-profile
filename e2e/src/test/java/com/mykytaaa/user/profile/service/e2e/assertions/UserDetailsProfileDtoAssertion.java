package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsResponseDto;
import com.mykytaaa.user.profile.service.e2e.util.ModelMapper;
import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsProfileDtoAssertion extends DtoAssertHandler<UserDetailsResponseDto>{
    @Override
    public void assertActualResponse(DataTable dataTable, UserDetailsResponseDto actualResponse, SoftAssertions softly) {
        UserDetailsResponseDto expectedResponse = ModelMapper.toUserDetailsResponseDto(dataTable);

        softly.assertThat(actualResponse.getId()).isEqualTo(expectedResponse.getId());
        softly.assertThat(actualResponse.getTelegramId()).isEqualTo(expectedResponse.getTelegramId());
        softly.assertThat(actualResponse.getPhoneNumber()).isEqualTo(expectedResponse.getPhoneNumber());
    }
}
