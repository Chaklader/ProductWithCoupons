package com.example.coupon.controllers;

import com.example.coupon.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
