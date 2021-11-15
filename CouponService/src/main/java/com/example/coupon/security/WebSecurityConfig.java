package com.example.coupon.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author chaklader on @date 11/11/21
 */
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(101)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsServiceImpl userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.httpBasic();
//        http.formLogin();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/index", "/couponapi/coupons/{code:^[A-Z]*$}", "/savecouponresponse", "/showGetCoupon", "/couponDetails")
                .hasAnyRole("ADMIN", "USER")
                .mvcMatchers(HttpMethod.GET, "/createcoupon", "/showCreateCoupon").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/couponapi/coupons", "/saveCoupon").hasRole("ADMIN")
                .mvcMatchers(HttpMethod.POST, "/getCoupon").hasAnyRole("ADMIN", "USER")
                .mvcMatchers("/", "/login", "/logout", "/showReg", "/registerUser").permitAll()
                .anyRequest().denyAll()
                .and().csrf().disable().logout().logoutSuccessUrl("/").invalidateHttpSession(true);


//        http.csrf(csrfConfigurer -> {
//
//            csrfConfigurer.ignoringAntMatchers("/couponapi/coupons/**");
//
//            RequestMatcher regexRequestMatcher = new RegexRequestMatcher("/couponapi/coupons/\\{code:^[A-Z]*$\\}", "POST");
////            regexRequestMatcher = new MvcRequestMatcher(new HandlerMappingIntrospector(), "/getCoupon");
//            csrfConfigurer.ignoringRequestMatchers(regexRequestMatcher);
//        });

//        http.cors(corsConfigurer -> {
//
//            CorsConfigurationSource configurationSource = request -> {
//
//                CorsConfiguration configuration = new CorsConfiguration();
//
//                configuration.setAllowedOrigins(
//                        List.of(
//                                "http://localhost:3000",
//                                "http://localhost:3000/**",
//                                "localhost:3000",
//                                "localhost:3000/**"
//                        ));
//
//                configuration.setAllowedMethods(
//                        List.of(
//                                "GET",
//                                "POST"
//                        ));
//
//                return configuration;
//            };
//
//            corsConfigurer.configurationSource(configurationSource);
//        });
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
