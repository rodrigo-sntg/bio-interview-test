package com.bionexo.provider.medicinefinder.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;
import com.bionexo.provider.medicinefinder.domain.medicinefinder.MedicineFinderResponse;
import com.bionexo.provider.medicinefinder.domain.medicinefinder.MedicineFinderUtils;
import com.bionexo.provider.medicinefinder.repository.BestSupplierRepository;
import com.bionexo.provider.medicinefinder.repository.WorseSupplierRepository;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineFinderApiController implements ErrorController{
	private static final Logger log = LoggerFactory.getLogger(MedicineFinderApiController.class);
	
	@Autowired
	private BestSupplierRepository bestSupplierRepository;
	
	@Autowired
	private WorseSupplierRepository worseSupplierRepository;
	
	private static final String PATH = "/error";
	
	/**
	 * 
	 * 
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/")
	public List<MedicineFinderResponse> getAll() {
		List<BestSupplier> bestSuppliers = (List<BestSupplier>) bestSupplierRepository.findAll();
		List<WorseSupplier> worseSuppliers = (List<WorseSupplier>) worseSupplierRepository.findAll();
		
		List<MedicineFinderResponse> responseList = new ArrayList<>();
		
		bestSuppliers.parallelStream().forEach(item -> responseList.add(MedicineFinderUtils.convert(item)));
		worseSuppliers.parallelStream().forEach(item -> responseList.add(MedicineFinderUtils.convert(item)));
		
		return responseList;
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}
}
