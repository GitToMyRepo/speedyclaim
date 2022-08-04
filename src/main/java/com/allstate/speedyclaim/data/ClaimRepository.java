package com.allstate.speedyclaim.data;

import com.allstate.speedyclaim.domain.Claim;
import com.allstate.speedyclaim.domain.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    public Optional<Claim> findByClaimId(Integer claimId);
    public List<Claim> findAllByPolicyNumber(Integer policyNumber);
    public List<Claim> findAllByInsuranceType(InsuranceType insuranceType);
}
