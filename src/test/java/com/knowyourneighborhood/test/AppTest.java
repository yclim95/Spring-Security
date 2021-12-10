package com.knowyourneighborhood.test;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.knowyourneighborhood.config.JPAConfig;
import com.knowyourneighborhood.config.SecurityConfig;
import com.knowyourneighborhood.config.WebMvcConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {WebMvcConfig.class,JPAConfig.class,SecurityConfig.class})
@WebAppConfiguration
public class AppTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;
	
	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	}
	
	// Mock Testing with user who has VIEW_STORE role
	@Test
	@WithMockUser(username = "John", roles = {"VIEW_STORE"})
	public void testStoresMapping() throws Exception{
		this.mockMvc
			.perform(MockMvcRequestBuilders.get("/viewStore"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	// Mock Testing - Authorize user can Add new Store?
	@Test
	@WithMockUser(username = "Maven", roles = {"ADD_STORE"})
	public void testAddStoreMapping() throws Exception {
		this.mockMvc
			.perform(MockMvcRequestBuilders.post("/registerStore")
				.param("name", "Starbucks")
				.param("phoneNumber","01234567")
				.param("localities","Malaysia")
				.with(csrf()))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
