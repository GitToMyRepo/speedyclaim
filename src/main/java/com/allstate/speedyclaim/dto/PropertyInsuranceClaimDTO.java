package com.allstate.speedyclaim.dto;

import com.allstate.speedyclaim.domain.PropertyInsuranceClaim;

public class PropertyInsuranceClaimDTO extends ClaimDTO {
    private String address;

    public PropertyInsuranceClaim toNewPropertyInsuranceClaim() {
        return new PropertyInsuranceClaim(getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), address);
    }

    public PropertyInsuranceClaim toPropertyInsuranceClaim() {
        return new PropertyInsuranceClaim(getClaimId(), getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), address);
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PropertyInsuranceClaimDTO{" +
                super.toString() + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
