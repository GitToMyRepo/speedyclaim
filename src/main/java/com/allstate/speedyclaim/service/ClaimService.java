package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.domain.Claim;
import com.allstate.speedyclaim.domain.InsuranceType;

import java.util.List;

public interface ClaimService {
    public List<Claim> getAllClaims();

    public Claim getClaimByClaimId(Integer claimId);

    public List<Claim> getClaimsByPolicyNumber(Integer policyNumber);

    public List<Claim> getClaimsByType(InsuranceType insuranceType);

    public Claim makeClaim(Claim claim);
}
