package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.ClaimRepository;
import com.allstate.speedyclaim.domain.Claim;
import com.allstate.speedyclaim.domain.ClaimStatus;
import com.allstate.speedyclaim.domain.InsuranceType;
import com.allstate.speedyclaim.exception.ClaimNotFoundException;
import com.allstate.speedyclaim.exception.InvalidClaimValueException;
import org.apache.commons.lang3.StringUtils;
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

    private static final Integer MAX_CLAIM_AMOUNT = 99999;

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<Claim> getAllClaims() {
        logger.info("Entering getAllClaims");
        logger.debug("returning " + this.claimRepository.findAll());
        //return this.claimRepository.findAll();
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
        if (claim.getClaimId() < MAX_CLAIM_AMOUNT) {
            claim.setClaimStatus(ClaimStatus.HANDLING_IN_MAIN_PLATFORM);
        }
        logger.info("saving " + claim);
        Claim saved = claimRepository.save(claim);
        logger.info("returning " + saved);
        return saved;
    }

    @Override
    public void deleteClaim(Integer claimId) {
        logger.debug("deleting " + claimId);
        this.claimRepository.deleteById(claimId);
    }

    @Override
    public Claim updateClaim(Integer claimId, Claim claim) {
        logger.debug("updating " + claimId);
        Claim returnedClaim = getClaimByClaimId(claimId);
        this.mergeClaim(returnedClaim, claim);
        logger.debug("updated " + returnedClaim);
        this.claimRepository.save(returnedClaim);
        logger.debug("returning " + returnedClaim);
        return returnedClaim;
    }

    @Override
    public Claim rejectClaim(Integer claimId) {
        logger.debug("rejecting " + claimId);
        Claim returnedClaim = updateClaimStatus(claimId, ClaimStatus.REJECTED);
        return returnedClaim;
    }

    private Claim updateClaimStatus(Integer claimId, ClaimStatus claimStatus) {
        Claim returnedClaim = getClaimByClaimId(claimId);
        returnedClaim.setClaimStatus(claimStatus);
        this.claimRepository.save(returnedClaim);
        return returnedClaim;
    }

    @Override
    public Claim acceptClaim(Integer claimId) {
        logger.debug("accepting " + claimId);
        Claim returnedClaim = updateClaimStatus(claimId, ClaimStatus.AWAITING_FOR_PAYMENT);
        return returnedClaim;
    }

    @Override
    public void payClaim(Integer claimId) {
        logger.debug("accepting " + claimId);
        updateClaimStatus(claimId, ClaimStatus.PAID);
    }

    private Claim mergeClaim(Claim original, Claim newClaimValues) {
//        if (newClaimValues.getClaimId() != null && original.getClaimId().intValue() == newClaimValues.getClaimId().intValue()) {
//            throw new InvalidClaimValueException("Claim Id", String.valueOf(newClaimValues.getClaimId()));
//        }
        if (newClaimValues.getPolicyNumber() != null && original.getPolicyNumber().intValue() == newClaimValues.getPolicyNumber().intValue()) {
            throw new InvalidClaimValueException("Policy number", String.valueOf(newClaimValues.getPolicyNumber()));
        }
        logger.info("insurance type class: " + newClaimValues.getInsuranceType().getClass());
        if (newClaimValues.getInsuranceType() != null && newClaimValues.getInsuranceType().equals(String.valueOf(original.getInsuranceType()))) {
            throw new InvalidClaimValueException("Insurance Type", String.valueOf(newClaimValues.getInsuranceType()));
        }
        original.setCustomerName(StringUtils.isNotBlank(newClaimValues.getCustomerName()) ? newClaimValues.getCustomerName() : original.getCustomerName());
        original.setStartedDate(newClaimValues.getStartedDate() != null ? newClaimValues.getStartedDate() : original.getStartedDate());
        original.setAmount(newClaimValues.getAmount() != null ? newClaimValues.getAmount() : original.getAmount());
        original.setReason(StringUtils.isNotBlank(newClaimValues.getReason()) ? newClaimValues.getReason() : original.getReason());
        original.setDescription(StringUtils.isNotBlank(newClaimValues.getDescription()) ? newClaimValues.getDescription() : original.getDescription());
        return original;
    }
}
