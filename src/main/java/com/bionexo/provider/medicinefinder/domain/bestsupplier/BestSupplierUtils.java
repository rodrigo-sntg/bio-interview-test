package com.bionexo.provider.medicinefinder.domain.bestsupplier;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;

public class BestSupplierUtils {

	
	public static BestSupplierResponse convert(BestSupplier best) {
		BestSupplierResponse response = new BestSupplierResponse();
		response.setDepartureCountryCode(best.getDepartureCountryCode());
		response.setDepartureDate(best.getDepartureDate());
		response.setDestinationCountryCode(best.getDestinationCountryCode());
		response.setEstimatedArrival(best.getEstimatedArrival());
		response.setMedicineName(best.getMedicineName());
		response.setMedicineType(best.getMedicineType());
		response.setPrice(best.getPrice());
		
		return response;
	}
	
	public static BestSupplier update(BestSupplier original, BestSupplierRequest details) {
		BestSupplier best = original;
		best.setDepartureDate(details.getDepartureDate());
		best.setDestinationCountryCode(details.getDestination());
		best.setEstimatedArrival(details.getEstimatedArrival());
		best.setDepartureCountryCode(details.getOrigin());
		best.setQuantityCount(details.getQuantityCount());
		
		return best;
	}
	
	
}
