package com.mykytaaa.user.profile.service.e2e.util;

import com.mykytaaa.user.profile.service.e2e.generated.model.ApiErrorDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserCreateRequestDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsCreateRequestDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsResponseDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsUpdateDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserDetailsUpdateRequestDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserResponseDto;
import com.mykytaaa.user.profile.service.e2e.generated.model.UserUpdateRequestDto;
import io.cucumber.datatable.DataTable;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@UtilityClass
public class ModelMapper {
    /**
     * Separator used for joining error details.
     */
    private static final String ERROR_DETAILS_SEPARATOR = ",";

    /**
     * Represents the variable identifier for ID.
     */
    private static final String VARIABLE_ID = "id";

    /**
     * Represents the variable identifier for first name.
     */
    private static final String VARIABLE_FIRST_NAME = "first_name";

    /**
     * Represents the variable identifier for last name.
     */
    private static final String VARIABLE_LAST_NAME = "last_name";
    /**
     * Constant representing the variable name for storing phone numbers.
     */
    private static final String VARIABLE_PHONE_NUMBER = "phone_number";
    /**
     * Constant representing the variable name for storing Telegram IDs.
     */
    private static final String VARIABLE_TELEGRAM_ID = "telegram_id";

    /**
     * Represents the variable identifier for email.
     */
    private static final String VARIABLE_EMAIL = "email";

    /**
     * Represents the variable identifier for user details ID.
     */
    private static final String VARIABLE_USER_DETAILS_ID = "userDetails.id";

    /**
     * Represents the variable identifier for user phone number.
     */
    private static final String VARIABLE_USER_PHONE_NUMBER = "userDetails.phone_number";

    /**
     * Represents the variable identifier for user telegram ID.
     */
    private static final String VARIABLE_USER_TELEGRAM_ID = "userDetails.telegram_id";
    /**
     * Constant representing the variable name for storing phone numbers within user details.
     */
    private static final String VARIABLE_USER_DETAILS_PHONE_NUMBER = "user_details.phone_number";
    /**
     * Constant representing the variable name for storing Telegram IDs within user details.
     */
    private static final String VARIABLE_USER_DETAILS_TELEGRAM_ID = "user_details.telegram_id";

    /**
     * Represents a regular expression for any number of spaces.
     */
    private static final String ANY_NUMBER_OF_SPACES = "\\s*";


    /**
     * Converts data from a DataTable to a UserResponseDto object.
     *
     * @param dataTable The DataTable containing user data.
     * @return The UserResponseDto object created from the DataTable.
     */
    public UserResponseDto toResponseDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserResponseDto.builder()
                .id(Long.valueOf(entry.get(VARIABLE_ID)))
                .firstName(entry.get(VARIABLE_FIRST_NAME))
                .lastName(entry.get(VARIABLE_LAST_NAME))
                .email(entry.get(VARIABLE_EMAIL))
                .userDetailsResponseDto(
                        UserDetailsResponseDto.builder()
                                .id(Long.valueOf(entry.get(VARIABLE_USER_DETAILS_ID)))
                                .phoneNumber(entry.get(VARIABLE_USER_PHONE_NUMBER))
                                .telegramId(entry.get(VARIABLE_USER_TELEGRAM_ID))
                                .build()
                ).build();
    }

    /**
     * Converts data from a DataTable to a UserResponseDto object for user creation.
     *
     * @param dataTable The DataTable containing user creation data.
     * @return The UserResponseDto object created from the DataTable.
     */
    public UserResponseDto toCreateResponseDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserResponseDto.builder()
                .firstName(entry.get(VARIABLE_FIRST_NAME))
                .lastName(entry.get(VARIABLE_LAST_NAME))
                .email(entry.get(VARIABLE_EMAIL))
                .userDetailsResponseDto(
                        UserDetailsResponseDto.builder()
                                .phoneNumber(entry.get(VARIABLE_USER_DETAILS_PHONE_NUMBER))
                                .telegramId(entry.get(VARIABLE_USER_DETAILS_TELEGRAM_ID))
                                .build()
                ).build();
    }

    /**
     * Converts data from a DataTable to an ApiErrorDto object.
     *
     * @param dataTable The DataTable containing API error data.
     * @return The ApiErrorDto object created from the DataTable.
     */
    public ApiErrorDto toApiErrorDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return ApiErrorDto.builder()
                .status(Integer.valueOf(entry.get("status")))
                .message(entry.get("message"))
                .details(toErrorDetailsList(entry))
                .build();
    }

    /**
     * Converts error details from a map to a list of strings.
     *
     * @param map The map containing error details.
     * @return The list of error details.
     */
    public List<String> toErrorDetailsList(Map<String, String> map) {
        return Arrays.stream(map.get("details")
                .split(ANY_NUMBER_OF_SPACES + ERROR_DETAILS_SEPARATOR + ANY_NUMBER_OF_SPACES)).toList();
    }

    /**
     * Converts data from a DataTable to a UserUpdateRequestDto object.
     *
     * @param dataTable The DataTable containing user update data.
     * @return The UserUpdateRequestDto object created from the DataTable.
     */
    public UserUpdateRequestDto toUserUpdateRequestDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserUpdateRequestDto.builder()
                .id(Long.valueOf(entry.get(VARIABLE_ID)))
                .firstName(entry.get(VARIABLE_FIRST_NAME))
                .lastName(entry.get(VARIABLE_LAST_NAME))
                .email(entry.get(VARIABLE_EMAIL))
                .userDetailsUpdateDto(UserDetailsUpdateDto.builder()
                        .id(Long.valueOf(entry.get(VARIABLE_USER_DETAILS_ID)))
                        .phoneNumber(entry.get(VARIABLE_USER_PHONE_NUMBER))
                        .telegramId(entry.get(VARIABLE_USER_TELEGRAM_ID))
                        .build())
                .build();
    }

    /**
     * Converts data from a DataTable to a UserDetailsResponseDto object.
     *
     * @param dataTable The DataTable containing user details data.
     * @return The UserDetailsResponseDto object created from the DataTable.
     */
    public UserDetailsResponseDto toUserDetailsResponseDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserDetailsResponseDto.builder()
                .id(Long.valueOf(entry.get(VARIABLE_ID)))
                .phoneNumber(entry.get(VARIABLE_PHONE_NUMBER))
                .telegramId(entry.get(VARIABLE_TELEGRAM_ID))
                .build();
    }

    /**
     * Converts data from a DataTable to a UserDetailsUpdateRequestDto object.
     *
     * @param dataTable The DataTable containing user details update data.
     * @return The UserDetailsUpdateRequestDto object created from the DataTable.
     */
    public UserDetailsUpdateRequestDto toUserDetailsUpdateRequestDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserDetailsUpdateRequestDto.builder()
                .id(Long.valueOf(entry.get(VARIABLE_ID)))
                .phoneNumber(entry.get(VARIABLE_PHONE_NUMBER))
                .telegramId(entry.get(VARIABLE_TELEGRAM_ID))
                .build();
    }

    /**
     * Converts data from a DataTable to a UserCreateRequestDto object.
     *
     * @param dataTable The DataTable containing user creation data.
     * @return The UserCreateRequestDto object created from the DataTable.
     */
    public UserCreateRequestDto toUserCreateRequestDto(DataTable dataTable) {
        final var entry = dataTable.asMap();

        return UserCreateRequestDto.builder()
                .firstName(entry.get(VARIABLE_FIRST_NAME))
                .lastName(entry.get(VARIABLE_LAST_NAME))
                .email(entry.get(VARIABLE_EMAIL))
                .userDetailsCreateRequestDto(UserDetailsCreateRequestDto.builder()
                        .phoneNumber(entry.get(VARIABLE_USER_DETAILS_PHONE_NUMBER))
                        .telegramId(entry.get(VARIABLE_USER_DETAILS_TELEGRAM_ID))
                        .build())
                .build();
    }
}
