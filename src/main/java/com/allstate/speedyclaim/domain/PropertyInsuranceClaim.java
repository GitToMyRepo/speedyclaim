package com.allstate.speedyclaim.domain;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.allstate.speedyclaim.domain.InsuranceType.PROPERTY;

@Entity
@Table(name="property_insurance_claim")
public class PropertyInsuranceClaim extends Claim {
    private String address;

    public PropertyInsuranceClaim() {
        super();
        setInsuranceType(PROPERTY);
    }

    public PropertyInsuranceClaim(Integer policyNumber, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description,
                                  String address) {
        this(null, policyNumber, customerName, startedDate, amount, reason, description, address);
    }

    public PropertyInsuranceClaim(Integer claimId, Integer policyNumber, String customerName, LocalDate startedDate,
                                  BigDecimal amount, String reason, String description, String address) {
        super(claimId, policyNumber, PROPERTY, customerName, startedDate, amount, reason, description);
        this.setAddress(address);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (StringUtils.isBlank(address)) {
            throw new IllegalArgumentException("address can not be null");
        } else {
            this.address = address;
        }
    }

    @Override
    public String toString() {
        return "PropertyInsuranceClaim{" +
                super.toString() + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
