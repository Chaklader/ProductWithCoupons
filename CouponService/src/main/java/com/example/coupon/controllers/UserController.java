package com.example.coupon.controllers;

import com.example.coupon.models.User;
import com.example.coupon.repos.UserRepo;
import com.example.coupon.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author chaklader
 * @date 11/12/21
 */

@Controller
public class UserController {


    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;


    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password) {

        boolean isLogin = securityService.login(email, password);
        if (isLogin) {
            return "index";
        }

        return "login";
    }

    @GetMapping("/showReg")
    public String showRegistrationPage() {
        return "registerUser";
    }

    @PostMapping("/registerUser")
    public String register(User user) {

        String password = user.getPassword();
        String encodedPassword = encoder.encode(password);

        user.setPassword(encodedPassword);
        userRepo.save(user);

        return "login";
    }
}
