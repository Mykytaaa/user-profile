package com.mykytaaa.user.profile.service.e2e.util;

import org.springframework.http.ResponseEntity;

public record TestContext(ResponseEntity<?> response, UserProfileOperationType operation) {

    /**
     * Retrieves the status code from the HTTP response.
     *
     * @return The status code of the HTTP response.
     */
    public int getStatusCode() {
        return response.getStatusCode().value();
    }
}
