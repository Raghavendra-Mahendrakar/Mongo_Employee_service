package com.pws.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pws.admin.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Base64;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Integer> {

@Query("db.User.find({\"email\": email})\n" +
        "\n" +
        "\n")
    Optional<User> findUserByEmail(String email);

    
}
