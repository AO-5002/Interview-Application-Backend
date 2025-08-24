package org.example.interviewprojectserver.repositories;

import jakarta.persistence.Id;
import org.example.interviewprojectserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.auth0_id = :auth")
    boolean existsByAuth0_id(@Param("auth") String auth);

    @Query("SELECT u FROM User u WHERE u.auth0_id = :auth")
    Optional<User> findByAuth0_id(String auth);
}
