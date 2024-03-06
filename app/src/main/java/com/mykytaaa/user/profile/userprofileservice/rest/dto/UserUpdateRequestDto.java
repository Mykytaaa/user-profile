package com.mykytaaa.user.profile.userprofileservice.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The UserUpdateRequestDto class represents the Data Transfer Object (DTO) for updating user information.
 * It includes fields such as the user identifier, first name, last name, email, and details for updating user details.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserUpdateRequestDto {

    /**
     * The unique identifier of the user.
     */
    @Schema(description = "The unique identifier of the user.")
    private long id;

    /**
     * The first name of the user.
     */
    @Schema(description = "The first name of the user")
    @NotNull(message = "First name should not be null")
    @Size(min = 1, max = 50)
    private String firstName;

    /**
     * The last name of the user.
     */
    @Schema(description = "The last name of the user")
    @NotNull(message = "Last name should not be null")
    @Size(min = 1, max = 50)
    private String lastName;

    /**
     * The email of the user.
     */
    @Schema(description = "The email of the user")
    @Email(message = "Email should be valid")
    @Size(max = 255)
    private String email;

    /**
     * Details for updating user details.
     */
    @Schema(description = "Details for updating user details")
    @Valid
    private UserDetailsUpdateDto userDetailsUpdateDto;
}
