package com.bionexo.provider.medicinefinder.domain.bestsupplier;

import com.bionexo.provider.medicinefinder.domain.base.BestSupplier;

public class BestSupplierUpdater {

	
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
