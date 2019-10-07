package com.bionexo.provider.medicinefinder.domain.worsesupplier;

import com.bionexo.provider.medicinefinder.domain.base.WorseSupplier;

public class WorseSupplierUtils {

	
	public static WorseSupplierResponse convert(WorseSupplier worse) {
		WorseSupplierResponse response = new WorseSupplierResponse();
		response.setArrivalCountryName(worse.getArrivalCountryName());
		response.setDepartureCountryName(worse.getDepartureCountryName());
		response.setDiscount(worse.getDiscount());
		response.setInboundDateTime(worse.getInboundDateTime());
		response.setMedicine(worse.getMedicine());
		response.setOutboundDateTime(worse.getOutboundDateTime());
		response.setTax(worse.getTax());
		response.setTotalBasePrice(worse.getTotalBasePrice());
		
		return response;
	}
	
	public static WorseSupplier update(WorseSupplier original, WorseSupplierRequest details) {
		WorseSupplier worse = original;

		worse.setArrivalCountryName(details.getArriveTo());
		worse.setDepartureCountryName(details.getDepartFrom());
		worse.setInboundDateTime(details.getInboundDate());
		worse.setNumberOfMedicines(details.getNumberOfMedicines());
		worse.setOutboundDateTime(details.getOutboundDate());
		
		return worse;
	}
	
	
}
