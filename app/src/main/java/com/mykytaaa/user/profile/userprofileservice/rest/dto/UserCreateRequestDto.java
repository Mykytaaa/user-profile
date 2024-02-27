package com.mykytaaa.user.profile.userprofileservice.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserCreateRequestDto(
        @Schema(description = "The first name of the user")
        @NotNull
        @Size(min = 1, max = 50, message = "The length of your first name should ne between 1 and 50 characters")
        String firstName,
        @Schema(description = "The last name of the user")
        @NotNull
        @Size(min = 1, max = 50, message = "The length of your last name should ne between 1 and 50 characters")
        String lastName,
        @Schema(description = "The email of the user")
        @NotNull
        @Email(message = "Please provide a valid email address")
        @Size(max = 255)
        String email,
        @Valid
        @Schema(description = "Details for creating a user")
        @NotNull
        UserDetailsCreateRequestDto userDetailsCreateRequestDto
) {
}
