package com.example.coupon.repos;

import com.example.coupon.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CouponRepo extends JpaRepository<Coupon, Long> {

    Coupon findByCode(String code);
}