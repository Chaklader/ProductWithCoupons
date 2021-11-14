package com.example.authorization.repos;

import com.example.authorization.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
