package com.mykytaaa.user.profile.userprofileservice.repository;

import com.mykytaaa.user.profile.userprofileservice.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    /**
     * Finds UserDetails by User.
     *
     * @param user The id of the User to find UserDetails.
     * @return Optional UserDetails if found, otherwise Optional#empty().
     */
    Optional<UserDetails> findUserDetailsByUserId(long user);

    /**
     * Checks if a UserDetails with the given ID exists.
     *
     * @param id The ID to check for existence.
     * @return {@code true} if an entity with the given ID exists, {@code false} otherwise.
     */
    boolean existsById(long id);
}
