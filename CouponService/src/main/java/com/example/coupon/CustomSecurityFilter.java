package com.example.coupon;

import javax.servlet.*;
import java.io.IOException;

public class CustomSecurityFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Before the filter");
        filterChain.doFilter(request, response);
        System.out.println("After the filter");
    }

}
