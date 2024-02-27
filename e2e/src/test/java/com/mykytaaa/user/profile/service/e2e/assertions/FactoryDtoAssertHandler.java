package com.mykytaaa.user.profile.service.e2e.assertions;

import com.mykytaaa.user.profile.service.e2e.util.UserProfileOperationType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FactoryDtoAssertHandler {

    private final Map<UserProfileOperationType, DtoAssertHandler> dtoAssertHandlerMap;

    public FactoryDtoAssertHandler(UserProfileDtoAssertion userProfileDtoAssertion,
                                   ApiErrorResponseAssertion apiErrorResponseAssertion,
                                   UserDetailsProfileDtoAssertion userDetailsProfileDtoAssertion) {
        this.dtoAssertHandlerMap = Map.of(
                UserProfileOperationType.FIND_BY_ID, userProfileDtoAssertion,
                UserProfileOperationType.ERROR, apiErrorResponseAssertion,
                UserProfileOperationType.UPDATE_USER, userProfileDtoAssertion,
                UserProfileOperationType.FIND_USER_DETAILS_BY_ID, userDetailsProfileDtoAssertion
        );
    }

    public DtoAssertHandler getInstance(UserProfileOperationType operationType) {
        if(dtoAssertHandlerMap.containsKey(operationType)) {
            return dtoAssertHandlerMap.get(operationType);
        }

        throw new IllegalArgumentException("An unprocessed operation type was obtained: " + operationType);
    }
}
