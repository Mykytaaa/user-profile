package com.mykytaaa.user.profile.userprofileservice.rest.adapter;

import com.mykytaaa.user.profile.userprofileservice.entity.User;
import com.mykytaaa.user.profile.userprofileservice.entity.UserDetails;
import com.mykytaaa.user.profile.userprofileservice.rest.dto.UserCreateRequestDto;
import com.mykytaaa.user.profile.userprofileservice.rest.dto.UserDetailsResponseDto;
import com.mykytaaa.user.profile.userprofileservice.rest.dto.UserDetailsUpdateRequestDto;
import com.mykytaaa.user.profile.userprofileservice.rest.dto.UserResponseDto;
import com.mykytaaa.user.profile.userprofileservice.rest.dto.UserUpdateRequestDto;
import com.mykytaaa.user.profile.userprofileservice.rest.mapper.UserCreateRequestMapper;
import com.mykytaaa.user.profile.userprofileservice.rest.mapper.UserDetailsResponseMapper;
import com.mykytaaa.user.profile.userprofileservice.rest.mapper.UserDetailsUpdateRequestMapper;
import com.mykytaaa.user.profile.userprofileservice.rest.mapper.UserResponseMapper;
import com.mykytaaa.user.profile.userprofileservice.rest.mapper.UserUpdateRequestMapper;
import com.mykytaaa.user.profile.userprofileservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * The UserServiceAdapter class serves as an adapter between the UserController and the underlying UserService.
 * It encapsulates the logic for handling user-related operations and mapping between different Data Transfer Objects.
 * and domain entities using various mappers.
 */
@Component
@RequiredArgsConstructor
public class UserServiceAdapter {

    /**
     * The UserService instance used to interact with the underlying user service.
     */
    private final UserService userService;

    /**
     * Mapper for converting UserCreateRequestDto to User entity.
     */
    private final UserCreateRequestMapper userCreateRequestMapper;

    /**
     * Mapper for converting UserUpdateRequestDto to User entity.
     */
    private final UserUpdateRequestMapper userUpdateRequestMapper;

    /**
     * Mapper for converting UserDetailsUpdateRequestDto to UserDetails entity.
     */
    private final UserDetailsUpdateRequestMapper userDetailsUpdateRequestMapper;

    /**
     * Mapper for converting User entity to UserResponseDto.
     */
    private final UserResponseMapper userResponseMapper;

    /**
     * Mapper for converting UserDetails entity to UserDetailsResponseDto.
     */
    private final UserDetailsResponseMapper userDetailsResponseMapper;

    /**
     * Creates a new user based on the provided UserCreateRequestDto.
     *
     * @param userCreateRequestDto The DTO containing user creation information.
     * @return The created UserResponseDto.
     */
    public UserResponseDto createUser(UserCreateRequestDto userCreateRequestDto) {
        final User user = userCreateRequestMapper.toUser(userCreateRequestDto);
        return userResponseMapper.toUserResponseDto(userService.save(user));
    }

    /**
     * Updates an existing user based on the provided UserUpdateRequestDto.
     *
     * @param userUpdateRequestDto The DTO containing user update information.
     * @return The updated UserResponseDto.
     */
    public UserResponseDto updateUser(UserUpdateRequestDto userUpdateRequestDto) {
        checkExistenceSourceById(userUpdateRequestDto.getId());
        final User user = userUpdateRequestMapper.toUser(userUpdateRequestDto);
        return userResponseMapper.toUserResponseDto(userService.save(user));
    }

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The UserResponseDto corresponding to the found user.
     */
    public UserResponseDto findUserById(long id) {
        final User user = userService.findUserById(id);
        return userResponseMapper.toUserResponseDto(user);
    }

    /**
     * Retrieves a list of users with pagination support.
     *
     * @param pageSize   The number of users per page.
     * @param pageNumber The page number.
     * @param sortBy     The field to sort the results by.
     * @param sortOrder  The sorting order (ASC or DESC).
     * @return A list of UserResponseDto objects representing the users on the requested page.
     */
    public List<UserResponseDto> findUsersWithPageable(int pageSize, int pageNumber, String sortBy, String sortOrder) {
        final Sort sort = sortOrder.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        final Page<User> usersPageable = userService.findAll(PageRequest.of(pageNumber - 1, pageSize, sort));
        final List<User> users = usersPageable.getContent();
        return users.stream().map(userResponseMapper::toUserResponseDto).toList();
    }

    /**
     * Retrieves user details by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The UserDetailsResponseDto corresponding to the found user details.
     */
    public UserDetailsResponseDto findUserDetailsById(long id) {
        final UserDetails userDetails = userService.findUserDetailsById(id);
        return userDetailsResponseMapper.toUserDetailsResponseDto(userDetails);
    }

    /**
     * Retrieves user details by their user identifier.
     *
     * @param id The user identifier.
     * @return The UserDetailsResponseDto corresponding to the found user details.
     */
    public UserDetailsResponseDto findUserDetailsByUserId(long id) {
        final UserDetails userDetails = userService.findUserDetailsByUserId(id);
        return userDetailsResponseMapper.toUserDetailsResponseDto(userDetails);
    }

    /**
     * Updates user details based on the provided UserDetailsUpdateRequestDto.
     *
     * @param userDetailsUpdateRequestDto The DTO containing user details update information.
     * @return The updated UserDetailsResponseDto.
     */
    public UserDetailsResponseDto updateUserDetails(UserDetailsUpdateRequestDto userDetailsUpdateRequestDto) {
        checkExistenceUserDetails(userDetailsUpdateRequestDto.getId());
        final UserDetails userDetails = userDetailsUpdateRequestMapper.toUserDetails(userDetailsUpdateRequestDto);
        userService.save(userDetails);
        return userDetailsResponseMapper.toUserDetailsResponseDto(userDetails);
    }

    private void checkExistenceSourceById(long id) {
        userService.findUserById(id);
    }

    private void checkExistenceUserDetails(long id) {
        userService.findUserDetailsById(id);
    }
}
