package com.bionexo.provider.medicinefinder.domain.medicinefinder;

public class MedicineFinderResponse {
	
	private String name;
    private double price;
    private String origin;
    private String destination;
    private String outboundDateTime;
    private String inboundDateTime;
    private String supplier;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getOutboundDateTime() {
		return outboundDateTime;
	}
	public void setOutboundDateTime(String outboundDateTime) {
		this.outboundDateTime = outboundDateTime;
	}
	public String getInboundDateTime() {
		return inboundDateTime;
	}
	public void setInboundDateTime(String inboundDateTime) {
		this.inboundDateTime = inboundDateTime;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
    
}
