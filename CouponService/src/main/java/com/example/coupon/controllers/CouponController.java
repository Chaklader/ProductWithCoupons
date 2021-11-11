package com.example.coupon.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {


    @GetMapping("/hello")
    public String helloUser() {
        return "hello World";
    }

    @GetMapping("/bye")
    public String byeUser() {
        return "Good bye";
    }
}
