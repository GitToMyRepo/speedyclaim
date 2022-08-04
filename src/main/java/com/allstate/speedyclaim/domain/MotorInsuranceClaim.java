package com.allstate.speedyclaim.domain;
import org.apache.commons.lang3.StringUtils;

import static com.allstate.speedyclaim.domain.InsuranceType.MOTOR;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="motor_insurance_claim")
public class MotorInsuranceClaim extends Claim {
    private String make;
    private String model;
    private Integer year;

    public MotorInsuranceClaim() {
        super();
        setInsuranceType(MOTOR);
    }

    public MotorInsuranceClaim(Integer policyNumber, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description,
                               String make, String model, Integer year) {
        this(null, policyNumber, customerName, startedDate, amount, reason, description, make, model, year);
    }

    public MotorInsuranceClaim(Integer claimId, Integer policyNumber, String customerName, LocalDate startedDate,
                               BigDecimal amount, String reason, String description, String make, String model, Integer year) {
        super(claimId, policyNumber, MOTOR, customerName, startedDate, amount, reason, description);
        this.setMake(make);
        setModel(model);
        setYear(year);
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
        if (StringUtils.isBlank(make)) {
            throw new IllegalArgumentException("make can not be null");
        } else {
            this.make = make;
        }
    }

    public void setModel(String model) {
        if (StringUtils.isBlank(model)) {
            throw new IllegalArgumentException("model can not be null");
        } else {
            this.model = model;
        }
    }

    public void setYear(Integer year) {
        if (year == null) {
            throw new IllegalArgumentException("year can not be null");
        } else {
            this.year = year;
        }
    }

    @Override
    public String toString() {
        return "MotorInsuranceClaim{" +
                super.toString() + '\'' +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
