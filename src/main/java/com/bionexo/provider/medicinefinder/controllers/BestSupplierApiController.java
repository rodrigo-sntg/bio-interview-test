package com.bionexo.provider.medicinefinder.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierRequest;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierResponse;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierUtils;
import com.bionexo.provider.medicinefinder.repository.BestSupplierRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/best")
public class BestSupplierApiController implements ErrorController{
	private static final Logger log = LoggerFactory.getLogger(BestSupplierApiController.class);
	
	@Autowired
	private BestSupplierRepository supplierRepository;
	
	private static final String PATH = "/error";
	
	/**
	   * Get all best supplier list.
	   *
	   * @return the list
	   */
	@GetMapping("/all")
	public List<BestSupplierResponse> getAll() {
		List<BestSupplier> suppliers = (List<BestSupplier>) supplierRepository.findAll();
		
		List<BestSupplierResponse> responseList = new ArrayList<>();
		
		
		suppliers.parallelStream().forEach(item -> responseList.add(BestSupplierUtils.convert(item)));
		
		return responseList;
	}
	
	/**
	   * Get best supplier list with object as param.
	   *
	   * @return the list
	   */
	@GetMapping("/")
	public List<BestSupplierResponse> getAll(@RequestParam(value = "bestSupplierRequest") String bestSupplierRequest) {
		List<BestSupplierResponse> responseList = new ArrayList<>();
		try {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		
			BestSupplierRequest ob =
			        new ObjectMapper().setDateFormat(df).readValue(bestSupplierRequest, BestSupplierRequest.class);
			
			List<BestSupplier> suppliers = (List<BestSupplier>) supplierRepository.findByDepartureCountryCodeAndDestinationCountryCodeAndDepartureDateAndEstimatedArrivalAndQuantityCount(ob.getOrigin(), ob.getDestination(),
					ob.getDepartureDate(), ob.getEstimatedArrival(), ob.getQuantityCount());
		
		
			suppliers.parallelStream().forEach(item -> responseList.add(BestSupplierUtils.convert(item)));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseList;
	}
	/**
	 * Gets users by id.
	 *
	 * @param id the user id
	 * @return the users by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<BestSupplierResponse> getSupplierById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		BestSupplier supplier =
				supplierRepository
				.findById(id);
		return ResponseEntity.ok().body(BestSupplierUtils.convert(supplier));
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<BestSupplierResponse> getSupplierByName(@PathVariable(value = "name") String name)
			throws ResourceNotFoundException {
		BestSupplier supplier =
				supplierRepository
				.findByMedicineName(name);
		return ResponseEntity.ok().body(BestSupplierUtils.convert(supplier));
	}
	/**
	 * Create supplier.
	 *
	 * @param best supplier
	 * @return the supplier
	 */
	@PostMapping("/")
	public BestSupplierResponse createUser(@Valid @RequestBody BestSupplier best) {
		return BestSupplierUtils.convert(supplierRepository.save(best));
	}
	/**
	 * Update user response entity.
	 *
	 * @param userId the user id
	 * @param userDetails the user details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<BestSupplierResponse> updateBestSupplier(
			@PathVariable(value = "id") Long id, @Valid @RequestBody BestSupplier details)
					throws ResourceNotFoundException {
		BestSupplier best =
				supplierRepository
				.findById(id);
		
		final BestSupplier updated = supplierRepository.save(best);
		
		return ResponseEntity.ok(BestSupplierUtils.convert(updated));
	}
	/**
	 * Delete best supplier map.
	 *
	 * @param id the best supplier id
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long id) throws Exception {
		BestSupplier sup =
				supplierRepository
				.findById(id);
		supplierRepository.delete(sup);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@Override
	public String getErrorPath() {
		return PATH;
	}
}
