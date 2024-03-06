package com.mykytaaa.user.profile.service.e2e.util;

import com.mykytaaa.user.profile.service.e2e.generated.model.ApiErrorDto;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;

import java.util.function.Supplier;

@UtilityClass
public class HttpRequestExceptionResolver {

    public TestContext sendRequest(Supplier<ResponseEntity<?>> request, UserProfileOperationType operationType) {
        try {
            return new TestContext(request.get(), operationType);
        } catch (RestClientResponseException ex) {
            final var apiError = ex.getResponseBodyAs(ApiErrorDto.class);
            return new TestContext(
                    ResponseEntity.status(ex.getStatusCode()).body(apiError),
                    UserProfileOperationType.ERROR
            );
        }
    }
}
