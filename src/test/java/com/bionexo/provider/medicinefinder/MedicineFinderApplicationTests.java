package com.bionexo.provider.medicinefinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@ComponentScan({"com.bionexo.provider.medicinefinder"})
@EntityScan("com.bionexo.provider.medicinefinder")
@EnableJpaRepositories("com.bionexo.provider.medicinefinder")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MedicineFinderApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	
	
	@LocalServerPort
	private int port;
	
	
	@Test
	public void testGetAllBestSuppliers() {
		
		try {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/api/v1/best/all").accept(
							MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			assertNotNull(result.getResponse().getContentAsString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllWorseSuppliers() {
		
		try {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/api/v1/worse/all").accept(
							MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			assertNotNull(result.getResponse().getContentAsString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAllMedicines() {
		try {
			RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/api/v1/medicine/").accept(
							MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			assertNotNull(result.getResponse().getContentAsString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
