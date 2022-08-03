package com.allstate.speedyclaim.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import static com.allstate.speedyclaim.domain.ClaimType.PROPERTY;

@Entity
public class PropertyInsuranceClaim {
    @Transient
    private ClaimType claimType = PROPERTY;
    @Id
    protected Integer policyNumber;
    private String address;

    public PropertyInsuranceClaim() {
        super();
    }

    public PropertyInsuranceClaim(Integer policyNumber, String address) {
        this.policyNumber = policyNumber;
        this.address = address;
    }

    public ClaimType getClaimType() {
        return claimType;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setClaimType(ClaimType claimType) {
        this.claimType = claimType;
    }

    public void setClaimInfo(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PropertyInsuranceClaim{" +
                "claimType=" + claimType +
                ", policyNumber=" + policyNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
