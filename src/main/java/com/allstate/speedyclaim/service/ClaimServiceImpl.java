package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.ClaimRepository;
import com.allstate.speedyclaim.domain.Claim;
import com.allstate.speedyclaim.domain.InsuranceType;
import com.allstate.speedyclaim.exception.ClaimNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {
    Logger logger = LoggerFactory.getLogger(ClaimService.class);
    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims() {
        logger.info("Entering getAllClaims");
        logger.debug("returning " + this.claimRepository.findAll());
        return this.claimRepository.findAll();
    }

    @Override
    public Claim getClaimByClaimId(Integer claimId) {
        logger.debug("searching claim for " + claimId);
        Optional<Claim> claimRecord = claimRepository.findByClaimId(claimId);
        if (claimRecord.isPresent()) {
            logger.info("returning " + claimRecord.get());
            return claimRecord.get();
        } else {
            logger.warn("Unable to find " + claimId);
            throw new ClaimNotFoundException(claimId);
        }
    }

    @Override
    public List<Claim> getClaimsByPolicyNumber(Integer policyNumber) {
        logger.debug("searching claims for " + policyNumber);
        return claimRepository.findAllByPolicyNumber(policyNumber);
    }

    @Override
    public List<Claim> getClaimsByType(InsuranceType insuranceType) {
        logger.debug("searching claims for " + insuranceType);
        return claimRepository.findAllByInsuranceType(insuranceType);
    }

    @Override
    public Claim makeClaim(Claim claim) {
        logger.debug("creating " + claim);
        return this.claimRepository.save(claim);
    }
}
