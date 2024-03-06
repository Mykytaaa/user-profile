package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FactoryDtoAssertHandler {

    /**
     * A map to store handlers for asserting DTOs based on user profile operation types.
     */
    private final Map<UserProfileOperationType, AbstractDtoAssertHandler> dtoAssertHandlerMap;

    /**
     * Constructs a new FactoryDtoAssertHandler with the provided assertions.
     *
     * @param userProfileDtoAssertion       Assertion for UserProfileDto
     * @param apiErrorResponseAssertion     Assertion for API error response
     * @param userDetailsProfileDtoAssertion Assertion for UserDetailsProfileDto
     * @param userProfileDtoCreateAssertion Assertion for creating UserProfileDto
     */
    public FactoryDtoAssertHandler(final UserProfileAbstractDtoAssertion userProfileDtoAssertion,
                                   final ApiErrorResponseAssertion apiErrorResponseAssertion,
                                   final UserDetailsProfileAbstractDtoAssertion userDetailsProfileDtoAssertion,
                                   final UserProfileAbstractDtoCreateAssertion userProfileDtoCreateAssertion) {
        this.dtoAssertHandlerMap = Map.of(
                UserProfileOperationType.FIND_BY_ID, userProfileDtoAssertion,
                UserProfileOperationType.ERROR, apiErrorResponseAssertion,
                UserProfileOperationType.UPDATE_USER, userProfileDtoAssertion,
                UserProfileOperationType.FIND_USER_DETAILS_BY_ID, userDetailsProfileDtoAssertion,
                UserProfileOperationType.UPDATE_USER_DETAILS, userDetailsProfileDtoAssertion,
                UserProfileOperationType.CREATE_USER, userProfileDtoCreateAssertion
        );
    }

    /**
     * Retrieves an instance of DtoAssertHandler based on the provided UserProfileOperationType.
     *
     * @param operationType The UserProfileOperationType to retrieve DtoAssertHandler for
     * @return The corresponding DtoAssertHandler instance
     * @throws IllegalArgumentException if the provided operationType is not found in the mapping
     */
    public AbstractDtoAssertHandler getInstance(UserProfileOperationType operationType) {
        if (dtoAssertHandlerMap.containsKey(operationType)) {
            return dtoAssertHandlerMap.get(operationType);
        }

        throw new IllegalArgumentException("An unprocessed operation type was obtained: " + operationType);
    }
}
