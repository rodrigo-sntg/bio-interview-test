package com.bionexo.provider.medicinefinder.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierRequest;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierResponse;
import com.bionexo.provider.medicinefinder.domain.bestsupplier.BestSupplierUtils;
import com.bionexo.provider.medicinefinder.domain.worsesupplier.WorseSupplierUtils;
import com.bionexo.provider.medicinefinder.domain.worsesupplier.WorseSupplierRequest;
import com.bionexo.provider.medicinefinder.domain.worsesupplier.WorseSupplierResponse;
import com.bionexo.provider.medicinefinder.repository.WorseSupplierRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/worse")
public class WorseSupplierApiController implements ErrorController{
	private static final Logger log = LoggerFactory.getLogger(WorseSupplierApiController.class);
	
	@Autowired
	private WorseSupplierRepository supplierRepository;
	
	private static final String PATH = "/error";
	
	/**
	   * Get all worse supplier list.
	   *
	   * @return the list
	   */
	@GetMapping("/all")
	public List<WorseSupplierResponse> getAll() {
		List<WorseSupplier> suppliers = (List<WorseSupplier>) supplierRepository.findAll();
		
		List<WorseSupplierResponse> responseList = new ArrayList<>();
		
		suppliers.parallelStream().forEach(item -> responseList.add(WorseSupplierUtils.convert(item)));
		
		return responseList;
	}
	
	
	/**
	   * Get best supplier list with object as param.
	   *
	   * @return the list
	   */
	@GetMapping("/")
	public List<WorseSupplierResponse> getAll(@RequestParam(value = "worseSupplierRequest") String worseSupplierRequest) {
		List<WorseSupplierResponse> responseList = new ArrayList<>();
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		
			WorseSupplierRequest ob =
			        new ObjectMapper().setDateFormat(df).readValue(worseSupplierRequest, WorseSupplierRequest.class);
			
			List<WorseSupplier> suppliers = (List<WorseSupplier>) supplierRepository.findByDepartureCountryNameAndArrivalCountryNameAndOutboundDateTimeAndInboundDateTimeAndNumberOfMedicines(ob.getDepartFrom(), 
					ob.getArriveTo(), ob.getOutboundDate(), ob.getInboundDate(), ob.getNumberOfMedicines());
		
		
			suppliers.parallelStream().forEach(item -> responseList.add(WorseSupplierUtils.convert(item)));
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
	 * Gets worse suppliers by id.
	 *
	 * @param id the worse supplier id
	 * @return the worse suppliers by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<WorseSupplierResponse> getSupplierById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		WorseSupplier supplier =
				supplierRepository
				.findById(id);
		return ResponseEntity.ok().body(WorseSupplierUtils.convert(supplier));
	}
	/**
	 * Create supplier.
	 *
	 * @param worse supplier
	 * @return the supplier
	 */
	@PostMapping("/")
	public WorseSupplierResponse createWorseSupplier(@Valid @RequestBody WorseSupplier worse) {
		return WorseSupplierUtils.convert(supplierRepository.save(worse));
	}
	/**
	 * Update worse supplier response entity.
	 *
	 * @param id the worse supplier id
	 * @param details the details of supplier
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<WorseSupplierResponse> updateWorseSupplier(
			@PathVariable(value = "id") Long id, @Valid @RequestBody WorseSupplierRequest details)
					throws ResourceNotFoundException {
		WorseSupplier worse =
				supplierRepository
				.findById(id);
		
		WorseSupplierUtils.update(worse, details);
		
		return ResponseEntity.ok(WorseSupplierUtils.convert(supplierRepository.save(worse)));
	}
	/**
	 * Delete worse supplier map.
	 *
	 * @param id the worse supplier id
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteWorseSupplier(@PathVariable(value = "id") Long id) throws Exception {
		WorseSupplier sup =
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
