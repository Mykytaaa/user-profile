package com.mykytaaa.user.profile.userprofileservice.service;

import com.mykytaaa.user.profile.userprofileservice.entity.User;
import com.mykytaaa.user.profile.userprofileservice.entity.UserDetails;
import com.mykytaaa.user.profile.userprofileservice.exception.ResourceNotFoundException;
import com.mykytaaa.user.profile.userprofileservice.repository.UserDetailsRepository;
import com.mykytaaa.user.profile.userprofileservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    /**
     * User domain name.
     */
    public static final String USER_DOMAIN_NAME = "User";

    /**
     * User details domain name.
     */
    public static final String USER_DETAILS_DOMAIN_NAME = "User Details";

    /**
     * Injection of UserRepository.
     */
    private final UserRepository userRepository;

    /**
     * Injection of UserDetailsRepository.
     */
    private final UserDetailsRepository userDetailsRepository;

    /**
     * Create a new User or update an existing record in database.
     *
     * @param user to be saved in database.
     * @return User The saved User entity.
     */
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Saves the given UserDetails into database.
     *
     * @param userDetails to be saved.
     * @return The saved UserDetails.
     */
    @Transactional
    public UserDetails save(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    /**
     * Find an existent User record in database.
     *
     * @param id refers to a record to be found.
     * @return User The found User entity.
     */
    public User findUserById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ResourceNotFoundException.ErrorMessage.ofId(USER_DOMAIN_NAME, id)));
    }

    /**
     * Find an existent User Details record in database.
     *
     * @param id refers to a record to be found.
     * @return User The found User entity.
     */
    public UserDetails findUserDetailsById(long id) {
        return userDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ResourceNotFoundException.ErrorMessage.ofId(USER_DETAILS_DOMAIN_NAME, id)));
    }

    /**
     * Find an existent User Details record in database.
     *
     * @param id refers to a record to be found.
     * @return User The found User entity.
     */
    public UserDetails findUserDetailsByUserId(long id) {
        return userDetailsRepository.findUserDetailsByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ResourceNotFoundException.ErrorMessage.ofUserDetailsByUserId(USER_DETAILS_DOMAIN_NAME, id)));
    }

    /**
     * Find an existent User record in database.
     *
     * @param email refers to a record to be found.
     * @return User The found User entity.
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        ResourceNotFoundException.ErrorMessage.ofMail(USER_DOMAIN_NAME, email)));
    }

    /**
     * Find all users in the database with pagination.
     *
     * @param pageable the parameter that contains the capacity and page number
     * @return Page<User> a page of Users
     */
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    /**
     * Checks if a user exists based on the provided ID.
     *
     * @param id The ID of the user to check.
     * @throws ResourceNotFoundException If the user does not exist.
     */
    public void checkIfUserExists(long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    ResourceNotFoundException.ErrorMessage.ofId(USER_DOMAIN_NAME, id));
        }
    }

    /**
     * Checks if user details exist based on the provided ID.
     *
     * @param id The ID of the user details to check.
     * @throws ResourceNotFoundException If the user details do not exist.
     */
    public void checkIfUserDetailsExists(long id) {
        if (!userDetailsRepository.existsById(id)) {
            throw new ResourceNotFoundException(
                    ResourceNotFoundException.ErrorMessage.ofUserDetailsByUserId(USER_DETAILS_DOMAIN_NAME, id));
        }
    }
}
