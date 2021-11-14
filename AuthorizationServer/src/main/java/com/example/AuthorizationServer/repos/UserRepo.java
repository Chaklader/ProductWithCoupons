package com.example.AuthorizationServer.repos;

import com.example.AuthorizationServer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
