//package com.example.coupon;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//@SpringBootTest
//@AutoConfigureMockMvc
//class CouponServiceApplicationTests {
//
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	void contextLoads() {
//
//	}
//
//
//	@Test
//	public void test_Get_Coupon_With_Coupon_Code_Without_Role() throws Exception {
//
//		mockMvc.perform(get("/couponapi/coupons/MIAMIVICE")).andExpect(status().isForbidden());
//	}
//
//	@Test
//	@WithMockUser(roles = {"USER"})
//	public void test_Get_Coupon_With_Coupon_Code_With_Role() throws Exception {
//
//		mockMvc.perform(get("/couponapi/coupons/MIAMIVICE")).andExpect(status().isOk())
//				.andExpect(content().string("{\"id\":6,\"code\":\"MIAMIVICE\",\"discount\":125.000,\"expDate\":\"12-09-2021\"}"));
//	}
//
//	@Test
//	@WithMockUser(roles = {"ADMIN"})
//	public void test_CreateCoupon_Without_Csrf_Forbidden() throws Exception {
//
//		mockMvc.perform(post("/couponapi/coupons").content("{\"code\": \"ZZZ123\",\"discount\": 105,\"expDate\": \"12-30-2021\"}").contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isForbidden());
//	}
//
//
//	@Test
//	@WithMockUser(roles = {"ADMIN"})
//	public void test_CreateCoupon_With_Csrf_Okay() throws Exception {
//
//		mockMvc.perform(post("/couponapi/coupons").content("{\"code\": \"ZZZ123\",\"discount\": 105,\"expDate\": \"12-30-2021\"}").contentType(MediaType.APPLICATION_JSON).with(csrf().asHeader("")))
//				.andExpect(status().isOk());
//	}
//
//
//	@Test
//	@WithMockUser(roles = {"USER"})
//	public void test_CreateCoupon_With_Csrf_Forbidden_For_normal_user() throws Exception {
//
//		mockMvc.perform(post("/couponapi/coupons").content("{\"code\": \"ZZZ123\",\"discount\": 105,\"expDate\": \"12-30-2021\"}").contentType(MediaType.APPLICATION_JSON).with(csrf().asHeader("")))
//				.andExpect(status().isForbidden());
//	}
//
//}
