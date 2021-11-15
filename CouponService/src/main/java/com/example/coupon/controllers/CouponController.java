package com.example.coupon.controllers;

import com.example.coupon.models.Coupon;
import com.example.coupon.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chaklader
 * @date 11/11/21
 */
//@CrossOrigin
@Controller
@RequestMapping("/")
public class CouponController {


    @Autowired
    private CouponRepo couponRepo;


    @GetMapping("/showCreateCoupon")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showCreateCoupon() {

        return "createcoupon";
    }

    @PostMapping("/saveCoupon")
    public String saveCoupon(Coupon coupon) {

        Coupon savedCoupon = couponRepo.save(coupon);

        return "savecouponresponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon() {

        return "getcoupon";
    }


    @PostMapping("/getCoupon")
    public ModelAndView showCoupon(String code) {

        Coupon coupon = couponRepo.findByCode(code);

        ModelAndView modelAndView = new ModelAndView("couponDetails");
        modelAndView.addObject(coupon);

        return modelAndView;
    }
}
