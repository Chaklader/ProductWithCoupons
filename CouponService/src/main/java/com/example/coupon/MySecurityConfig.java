//package com.example.coupon;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//
//@Configuration
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    private CustomAuthenticationProvider authenticationProvider;
//
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////
//////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////
////        UserDetails user = User.withUsername("arefe").password(passwordEncoder.encode("1234")).authorities("read").build();
////        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
////        inMemoryUserDetailsManager.createUser(user);
////
////        auth.userDetailsService(inMemoryUserDetailsManager);
////    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
////        http.formLogin();
//        http.httpBasic();
////        http.authorizeRequests().anyRequest().authenticated();
//        http.authorizeRequests().antMatchers("/hello").authenticated();
//        http.addFilterBefore(new CustomSecurityFilter(), BasicAuthenticationFilter.class);
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//
//        return new BCryptPasswordEncoder();
//    }
//
//}
