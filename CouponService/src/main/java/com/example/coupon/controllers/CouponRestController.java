package com.example.coupon.controllers;

import com.example.coupon.models.Coupon;
import com.example.coupon.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin
@RestController
@RequestMapping("/couponapi")
public class CouponRestController {


    @Autowired
    private CouponRepo couponRepo;


    @PostMapping("/coupons")
    @PreAuthorize("hasRole('ADMIN')")
    public Coupon createCoupon(@RequestBody Coupon coupon) {

        Coupon createdCoupon = couponRepo.save(coupon);
        return createdCoupon;
    }

    @GetMapping("/coupons/{code}")
//    @PostAuthorize("returnObject.discount < 60")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Coupon getCoupon(@PathVariable("code") String code) {

        Coupon coupon = couponRepo.findByCode(code);
        return coupon;
    }


}
