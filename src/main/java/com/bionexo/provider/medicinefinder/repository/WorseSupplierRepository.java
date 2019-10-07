package com.bionexo.provider.medicinefinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;

public interface WorseSupplierRepository extends CrudRepository<WorseSupplier, Long> {
	
	WorseSupplier findById(Long id);
	
	
	/**
	 * sorry for the big method name
	 * 
	 * @param origin
	 * @param destination
	 * @param departureDate
	 * @param estimatedArrival
	 * @param quantityCount
	 * @return
	 */
	List<WorseSupplier> findByDepartureCountryNameAndArrivalCountryNameAndOutboundDateTimeAndInboundDateTimeAndNumberOfMedicines(String origin, String destination, 
    		String departureDate, String estimatedArrival, int quantityCount);

}
