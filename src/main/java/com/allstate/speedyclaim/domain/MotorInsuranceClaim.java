package com.allstate.speedyclaim.domain;
import static com.allstate.speedyclaim.domain.ClaimType.MOTOR;

import javax.persistence.*;

@Entity
public class MotorInsuranceClaim {
    @Transient
    private final ClaimType claimType = MOTOR;
    @Id
    protected Integer policyNumber;
    private String make;
    private String model;
    private Integer year;

    public MotorInsuranceClaim() {
        super();
    }

    public MotorInsuranceClaim(Integer policyNumber, String make, String model, Integer year) {
        this.policyNumber = policyNumber;
        this.make = make;
        this.model = model;
        this.year = year;
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
        return "MotorInsuranceClaim{" +
                "claimType=" + claimType +
                ", policyNumber=" + policyNumber +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
