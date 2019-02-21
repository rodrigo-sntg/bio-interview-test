package com.bionexo.provider.medicinefinder.domain.worsesupplier;

public class WorseSupplierResponse {

    private String medicine;
    private double totalBasePrice;
    private double tax;
    private double discount;
    private String departureCountryName;
    private String arrivalCountryName;
    private String outboundDateTime;
    private String inboundDateTime;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public double getTotalBasePrice() {
        return totalBasePrice;
    }

    public void setTotalBasePrice(double totalBasePrice) {
        this.totalBasePrice = totalBasePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDepartureCountryName() {
        return departureCountryName;
    }

    public void setDepartureCountryName(String departureCountryName) {
        this.departureCountryName = departureCountryName;
    }

    public String getArrivalCountryName() {
        return arrivalCountryName;
    }

    public void setArrivalCountryName(String arrivalCountryName) {
        this.arrivalCountryName = arrivalCountryName;
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
}
