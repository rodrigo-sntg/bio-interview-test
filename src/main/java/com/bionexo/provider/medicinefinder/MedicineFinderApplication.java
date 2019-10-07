package com.bionexo.provider.medicinefinder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bionexo.provider.medicinefinder.country.Country;
import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;
import com.bionexo.provider.medicinefinder.repository.BestSupplierRepository;
import com.bionexo.provider.medicinefinder.repository.WorseSupplierRepository;

@SpringBootApplication
public class MedicineFinderApplication implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(MedicineFinderApplication.class);

	@Autowired
	private BestSupplierRepository bestSupplierRepository;

	@Autowired
	private WorseSupplierRepository worseSupplierRepository;

	List<Country> countries = new ArrayList<Country>();


	public static void main(String[] args) {
		SpringApplication.run(MedicineFinderApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("StartApplication...");

		countries = fillCountries();


		DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;

		for(int i = 0; i < 20 ; i++) {

			BestSupplier bsresponse = new BestSupplier();
			String departureCountryCode = getRandomCountryAlphaCode(); 
			bsresponse.setDepartureCountryCode(departureCountryCode);

			String destinationCountryCode = getRandomCountryAlphaCode();
			bsresponse.setDestinationCountryCode(destinationCountryCode);

			String departureDate = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			bsresponse.setDepartureDate(departureDate);

			String estimatedArrival = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			bsresponse.setEstimatedArrival(estimatedArrival);

			String medicineName = "Med " + (i +1);
			bsresponse.setMedicineName(medicineName);
			String medicineType = "Type " + (i + 1);
			bsresponse.setMedicineType(medicineType);
			bsresponse.setPrice(Double.valueOf(String.valueOf(getRandomFromRange(10, 500))));

			String departureDates = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			bsresponse.setDepartureDate(departureDates);

			String estimatedArrivals = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			bsresponse.setEstimatedArrival(estimatedArrivals);

			bsresponse.setQuantityCount(i);

			bestSupplierRepository.save(bsresponse);
		}




		for(int i = 0; i < 20 ; i++) {

			WorseSupplier wsresponse = new WorseSupplier();

			String departureCountryCodea = getRandomCountryAlphaCode(); 
			wsresponse.setDepartureCountryName(departureCountryCodea);

			String destinationCountryCodea = getRandomCountryAlphaCode();
			wsresponse.setArrivalCountryName(destinationCountryCodea);

			String departureDatea = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			wsresponse.setInboundDateTime(departureDatea);

			String estimatedArrivala = isoLocalDate.format(LocalDate.of(2012, 6, 30));
			wsresponse.setOutboundDateTime(estimatedArrivala);

			String medicineNamea = "Med " + i;
			wsresponse.setMedicine(medicineNamea);
			wsresponse.setTax(Double.valueOf(String.valueOf(getRandomFromRange(1, 10))));

			wsresponse.setTotalBasePrice(Double.valueOf(String.valueOf(getRandomFromRange(10, 500))));
			wsresponse.setDiscount(Double.valueOf(String.valueOf(getRandomFromRange(0, 5))));

			wsresponse.setNumberOfMedicines(getRandomFromRange(1,50));

			worseSupplierRepository.save(wsresponse);
		}


		worseSupplierRepository.findAll().forEach(x -> System.out.println(x));
		bestSupplierRepository.findAll().forEach(x -> System.out.println(x));

	}

	private String getRandomCountryAlphaCode() {
		return countries.get(getRandomFromRange(0, countries.size() - 1)).getAlpha3Code();
	}

	private List<Country> fillCountries() {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<Country>> response = restTemplate.exchange(
				"https://restcountries.eu/rest/v2/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Country>>(){});
		List<Country> countries = response.getBody();
		return countries;
	}

	private static int getRandomFromRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be higher than min.");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}


