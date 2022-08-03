package com.allstate.speedyclaim.domain;

import static com.allstate.speedyclaim.domain.ClaimType.PET;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PetInsuranceClaim {
    @Transient
    private ClaimType claimType = PET;
    @Id
    protected Integer policyNumber;
    private String type;
    private String breed;

    public PetInsuranceClaim() {
        super();
    }

    public PetInsuranceClaim(Integer policyNumber, String type, String breed) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.breed = breed;
    }

    public ClaimType getClaimType() {
        return claimType;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public void setClaimType(ClaimType claimType) {
        this.claimType = claimType;
    }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "PetInsuranceClaim{" +
                "claimType=" + claimType +
                ", policyNumber=" + policyNumber +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
