package com.allstate.speedyclaim.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimId;
    private Integer policyNumber;
    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;
    private String customerName;
    private LocalDate startedDate;
    private BigDecimal amount;
    private String reason;
    private String description;

    public Claim() {
    }

    public Claim(Integer claimId, Integer policyNumber, InsuranceType insuranceType, ClaimStatus claimStatus, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.insuranceType = insuranceType;
        this.claimStatus = claimStatus;
        this.customerName = customerName;
        this.startedDate = startedDate;
        this.amount = amount;
        this.reason = reason;
        this.description = description;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public InsuranceType getInsuranceType() {
        return insuranceType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getStartedDate() {
        return startedDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public String getDescription() {
        return description;
    }

    public ClaimStatus getClaimStatus() { return claimStatus; }

    public void setPolicyNumber(Integer policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setInsuranceType(InsuranceType insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStartedDate(LocalDate startedDate) {
        this.startedDate = startedDate;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClaimStatus(ClaimStatus claimStatus) {
        this.claimStatus = claimStatus;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", policyNumber=" + policyNumber +
                ", insuranceType=" + insuranceType +
                ", claimStatus=" + claimStatus +
                ", customerName='" + customerName + '\'' +
                ", startedDate=" + startedDate +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
