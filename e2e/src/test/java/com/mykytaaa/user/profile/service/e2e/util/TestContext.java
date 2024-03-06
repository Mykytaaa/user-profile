package com.mykytaaa.user.profile.service.e2e.util;

import org.springframework.http.ResponseEntity;

public record TestContext(ResponseEntity<?> response, UserProfileOperationType operation) {

    public int getStatusCode() {
        return response.getStatusCode().value();
    }
}
