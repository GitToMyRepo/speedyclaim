package com.allstate.speedyclaim.dto;

import com.allstate.speedyclaim.domain.InsuranceType;
import com.allstate.speedyclaim.domain.MotorInsuranceClaim;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MotorInsuranceClaimDTO extends ClaimDTO {
    private String make;
    private String model;
    private Integer year;

    public MotorInsuranceClaim toNewMotorInsuranceClaim() {
        return new MotorInsuranceClaim(getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), make, model, year);
    }

    public MotorInsuranceClaim toMotorInsuranceClaim() {
        return new MotorInsuranceClaim(getClaimId(), getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), make, model, year);
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "MotorInsuranceClaimDTO{" +
                super.toString() + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
