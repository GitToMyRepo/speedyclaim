package com.allstate.speedyclaim.dto;

import com.allstate.speedyclaim.domain.InsuranceType;
import com.allstate.speedyclaim.domain.Claim;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ClaimDTO {
    private Integer claimId;
    private Integer policyNumber;
    private InsuranceType insuranceType;
    private String customerName;
    private LocalDate startedDate;
    private BigDecimal amount;
    private String reason;
    private String description;

    public Claim toNewClaim() {
        return new Claim(null, policyNumber, insuranceType, customerName, startedDate, amount, reason, description);
    }

    public Claim toClaim() {
        return new Claim(claimId, policyNumber, insuranceType, customerName, startedDate, amount, reason, description);
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

    @Override
    public String toString() {
        return "ClaimDTO{" +
                "policyNumber=" + policyNumber +
                ", insuranceType=" + insuranceType +
                ", customerName='" + customerName + '\'' +
                ", startedDate=" + startedDate +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
