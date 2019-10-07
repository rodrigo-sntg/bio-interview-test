package com.bionexo.provider.medicinefinder.domain.medicinefinder;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;
import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;

public class MedicineFinderUtils {

	
	public static MedicineFinderResponse convert(BestSupplier best) {
		MedicineFinderResponse response = new MedicineFinderResponse();
		
		response.setDestination(best.getDestinationCountryCode());
		response.setInboundDateTime(best.getDepartureDate());
		response.setName(best.getMedicineName());
		response.setOrigin(best.getDepartureCountryCode());
		response.setOutboundDateTime(best.getEstimatedArrival());
		response.setPrice(best.getPrice());
		response.setSupplier(BestSupplier.class.getSimpleName());
		
		return response;
	}
	
	public static MedicineFinderResponse convert(WorseSupplier worse) {
		MedicineFinderResponse response = new MedicineFinderResponse();
		
		response.setDestination(worse.getArrivalCountryName());
		response.setOrigin(worse.getDepartureCountryName());
		response.setInboundDateTime(worse.getInboundDateTime());
		response.setOutboundDateTime(worse.getOutboundDateTime());
		response.setName(worse.getMedicine());
		response.setPrice(worse.getTotalBasePrice());
		response.setSupplier(WorseSupplier.class.getSimpleName());
		
		return response;
	}
	
	
}
