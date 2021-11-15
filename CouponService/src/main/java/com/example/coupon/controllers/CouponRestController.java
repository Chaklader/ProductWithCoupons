package com.example.coupon.controllers;

import com.example.coupon.models.Coupon;
import com.example.coupon.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {


    @Autowired
    private CouponRepo couponRepo;

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon) {

        Coupon createdCoupon = couponRepo.save(coupon);
        return createdCoupon;
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {

        Coupon coupon = couponRepo.findByCode(code);
        return coupon;
    }


}
