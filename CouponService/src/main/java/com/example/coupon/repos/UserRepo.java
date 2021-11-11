package com.example.coupon.repos;

import com.example.coupon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
