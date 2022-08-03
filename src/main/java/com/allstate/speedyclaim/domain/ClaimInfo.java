package com.allstate.speedyclaim.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class ClaimInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer policyNumber;
    protected String insuranceType;
    protected String customerName;
    protected LocalDate startedDate;
    protected BigDecimal amount;
    protected String reason;
    protected String description;

    public ClaimInfo() {
    }

    public ClaimInfo(Integer policyNumber, String insuranceType, String customerName, LocalDate startedDate, BigDecimal amount, String reason, String description) {
        this.policyNumber = policyNumber;
        this.insuranceType = insuranceType;
        this.customerName = customerName;
        this.startedDate = startedDate;
        this.amount = amount;
        this.reason = reason;
        this.description = description;
    }

    public Integer getPolicyNumber() {
        return policyNumber;
    }

    public String getInsuranceType() {
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

    public void setInsuranceType(String insuranceType) {
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
        return "Claim{" +
                "policyNumber=" + policyNumber +
                ", insuranceType='" + insuranceType + '\'' +
                ", customerName='" + customerName + '\'' +
                ", startedDate=" + startedDate +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
