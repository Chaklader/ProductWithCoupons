package com.example.product.controllers;


import com.example.product.dto.Coupon;
import com.example.product.models.Product;
import com.example.product.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("/productapi")
public class ProductController {


    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${coupon.getUrl}")
    private String couponURL;


    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {


        String couponCode = product.getCouponCode();
        Coupon coupon = restTemplate.getForObject(couponURL + couponCode, Coupon.class);

        BigDecimal productPrice = product.getPrice();
        BigDecimal discount = coupon.getDiscount();

        BigDecimal productPriceAfterDiscountApplied = productPrice.subtract(discount);
        product.setPrice(productPriceAfterDiscountApplied);

        return productRepo.save(product);
    }
}
