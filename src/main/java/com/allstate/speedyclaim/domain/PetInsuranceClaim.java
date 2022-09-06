package com.allstate.speedyclaim.domain;

import org.apache.commons.lang3.StringUtils;

import static com.allstate.speedyclaim.domain.InsuranceType.PET;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="pet_insurance_claim")
public class PetInsuranceClaim extends Claim {
    private String type;
    private String breed;

    public PetInsuranceClaim() {
        super();
        this.setInsuranceType(PET);
    }


    public PetInsuranceClaim(Integer policyNumber, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description,
                             String type, String breed) {
        this(null, policyNumber, customerName, startedDate, amount, reason, description, type, breed);
    }

    public PetInsuranceClaim(Integer claimId, Integer policyNumber, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description,
                             String type, String breed) {
        super(claimId, policyNumber, PET, ClaimStatus.NEW_CLAIM, customerName, startedDate, amount, reason, description);
        setType(type);
        setBreed(breed);
    }

    public String getType() {
        return type;
    }

    public String getBreed() {
        return breed;
    }

    public void setType(String type) {
        if (StringUtils.isBlank(type)) {
            throw new IllegalArgumentException("type can not be null");
        } else {
            this.type = type;
        }
    }

    public void setBreed(String breed) {
        if (StringUtils.isBlank(breed)) {
            throw new IllegalArgumentException("breed can not be null");
        } else {
            this.breed = breed;
        }
    }

    @Override
    public String toString() {
        return "PetInsuranceClaim{" +
                super.toString() + '\'' +
                "type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
