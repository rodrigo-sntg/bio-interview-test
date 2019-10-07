package com.bionexo.provider.medicinefinder.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bionexo.provider.medicinefinder.country.Country;

@RestController
@RequestMapping("/api/v1/countries")
public class CountriesApiController implements ErrorController{
	private static final Logger log = LoggerFactory.getLogger(CountriesApiController.class);
	
	private static final String PATH = "/error";
	
	@GetMapping("/")
	public List<Country> getAll() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Country>> response = restTemplate.exchange(
				"https://restcountries.eu/rest/v2/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Country>>(){});
		List<Country> countries = response.getBody();
		List<Country> shortList = new ArrayList<>();
		
		for(int i = 0; i< 20 ; i++) {
			shortList.add(countries.get(i));
		}
		
		return shortList;

	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return PATH;
	}
}
