package com.knowyourneighborhood.test;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import com.knowyourneighborhood.StoreService;
import com.knowyourneighborhood.config.JPAConfig;
import com.knowyourneighborhood.config.SecurityConfig;
import com.knowyourneighborhood.config.WebMvcConfig;
import com.knowyourneighborhood.model.Store;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {WebMvcConfig.class,JPAConfig.class,SecurityConfig.class})
@WebAppConfiguration
public class UnitTest {
	@Autowired
	private StoreService storeService;
	
	@Bean
	public StoreService storeService() {
		return new StoreService();
	}

	@Test
	public void testGetAllStore() {
		List<Store> stores = storeService.listAll();
		Assertions.assertEquals(1,stores.size());
	}
	
	@Test
	public void testSaveStore() {
		Store mockStore = new Store();
		mockStore.setStoreID((long)3);
		mockStore.setName("StarBucks");
		mockStore.setPhoneNumber("123341");
		mockStore.setLocalities("Malaysia");
		
		Store store = storeService.saveStore(mockStore);
		Assertions.assertNotNull(store);
	}
	
	@Test
	public void testFindStore() {
		List<Store> stores = storeService.search("StarBucks");
		Assertions.assertNotNull(stores);
	}
	
}
