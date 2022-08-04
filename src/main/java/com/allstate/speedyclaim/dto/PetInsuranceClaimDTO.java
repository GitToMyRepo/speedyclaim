package com.allstate.speedyclaim.dto;

import com.allstate.speedyclaim.domain.PetInsuranceClaim;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PetInsuranceClaimDTO extends ClaimDTO {
    private String type;
    private String breed;

    public PetInsuranceClaim toNewPetInsuranceClaim() {
        return new PetInsuranceClaim(getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), type, breed);
    }

    public PetInsuranceClaim toPetInsuranceClaim() {
        return new PetInsuranceClaim(getClaimId(), getPolicyNumber(), getCustomerName(), getStartedDate(), getAmount(), getReason(),
                getDescription(), type, breed);
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "PetInsuranceClaimDTO{" +
                super.toString() + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
