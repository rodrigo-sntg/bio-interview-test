package com.bionexo.provider.medicinefinder.domain.worsesupplier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class WorseSupplierRequest {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String departFrom;
    private String arriveTo;
    private String outboundDate;
    private String inboundDate;
    private int numberOfMedicines;

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        this.departFrom = departFrom;
    }

    public String getArriveTo() {
        return arriveTo;
    }

    public void setArriveTo(String arriveTo) {
        this.arriveTo = arriveTo;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public void setNumberOfMedicines(int numberOfMedicines) {
        this.numberOfMedicines = numberOfMedicines;
    }
}
