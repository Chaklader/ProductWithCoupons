package com.example.coupon.security;

/**
 * @author chaklader
 * @date 11/12/21
 */
public interface SecurityService {

    boolean login(String username, String password);
}
