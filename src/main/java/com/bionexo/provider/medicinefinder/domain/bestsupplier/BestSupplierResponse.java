package com.bionexo.provider.medicinefinder.domain.bestsupplier;

public class BestSupplierResponse {

    private String medicineName;
    private double price;
    private String medicineType;
    private String departureCountryCode;
    private String destinationCountryCode;
    private String departureDate;
    private String estimatedArrival;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(String medicineType) {
        this.medicineType = medicineType;
    }

    public String getDepartureCountryCode() {
        return departureCountryCode;
    }

    public void setDepartureCountryCode(String departureCountryCode) {
        this.departureCountryCode = departureCountryCode;
    }

    public String getDestinationCountryCode() {
        return destinationCountryCode;
    }

    public void setDestinationCountryCode(String destinationCountryCode) {
        this.destinationCountryCode = destinationCountryCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEstimatedArrival() {
        return estimatedArrival;
    }

    public void setEstimatedArrival(String estimatedArrival) {
        this.estimatedArrival = estimatedArrival;
    }
}
