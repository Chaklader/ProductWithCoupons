package com.example.coupon.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


	private static final String RESOURCE_ID = "couponservice";


	@Value("${publicKey}")
	public String publicKey;

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	String issuerUri;


	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(RESOURCE_ID);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/couponapi/coupons/{code:^[A-Z]*$}", "/codeHandlerPage").hasAnyRole("USER", "ADMIN")
				.mvcMatchers(HttpMethod.POST, "/couponapi/coupons").hasRole("ADMIN")
				.anyRequest().denyAll().and().csrf().disable();
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {

		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setVerifierKey(publicKey);

		return jwtAccessTokenConverter;
	}



//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//				.authorizeRequests(authorizeRequests ->
//						authorizeRequests
//								.antMatchers("/services").hasAuthority("SCOPE_services:read")
//								.anyRequest().authenticated()
//				)
//				.oauth2ResourceServer(oauth2ResourceServer ->
//						oauth2ResourceServer
//								.jwt(jwt ->
//										jwt.decoder(JwtDecoders.fromIssuerLocation(issuerUri))
//								)
//				);
//	}

}