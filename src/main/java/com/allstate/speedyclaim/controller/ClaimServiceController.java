package com.allstate.speedyclaim.controller;

import com.allstate.speedyclaim.domain.Claim;
import com.allstate.speedyclaim.domain.InsuranceType;
import com.allstate.speedyclaim.dto.MotorInsuranceClaimDTO;
import com.allstate.speedyclaim.dto.PetInsuranceClaimDTO;
import com.allstate.speedyclaim.dto.PropertyInsuranceClaimDTO;
import com.allstate.speedyclaim.service.ClaimService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimServiceController {
    Logger logger = LoggerFactory.getLogger(ClaimServiceController.class);

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<Claim> getAllClaims(@RequestParam(name="policyNumber", required = false) Integer policyNumber,
                                    @RequestParam(name="type", required = false) InsuranceType insuranceType) {
        logger.debug("Entering getAllClaims ");
        logger.debug("Policy number " + policyNumber);
        logger.debug("Insurance type " + insuranceType);
        List<Claim> claims = new ArrayList<Claim>();
        if (policyNumber == null && insuranceType == null) {
            claims = claimService.getAllClaims();
        } else if (policyNumber != null) {
            claims = claimService.getClaimsByPolicyNumber(policyNumber);
        } else if (insuranceType != null) {
            claims = claimService.getClaimsByType(insuranceType);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("returning " + claims);
        }
        return claims;
    }

    @GetMapping("/{claimId}")
    public Claim getClaimByClaimId(@PathVariable("claimId") Integer claimId) {
        logger.info("Entering getClaimByClaimId");
        return this.claimService.getClaimByClaimId(claimId);
    }

    @PostMapping("/motor")
    public Claim makeClaim(@RequestBody MotorInsuranceClaimDTO motorInsuranceClaimDTO) {
        logger.debug("making claim " + motorInsuranceClaimDTO);
        Claim savedClaim = claimService.makeClaim(motorInsuranceClaimDTO.toNewMotorInsuranceClaim());
        logger.info("saved " + savedClaim);
        return savedClaim;
    }

    @PostMapping("/pet")
    public Claim makeClaim(@RequestBody PetInsuranceClaimDTO petInsuranceClaimDTO) {
        logger.debug("making claim " + petInsuranceClaimDTO);
        Claim savedClaim = claimService.makeClaim(petInsuranceClaimDTO.toNewPetInsuranceClaim());
        logger.info("saved " + savedClaim);
        return savedClaim;
    }

    @PostMapping("/property")
    public Claim makeClaim(@RequestBody PropertyInsuranceClaimDTO propertyInsuranceClaimDTO) {
        logger.debug("making claim " + propertyInsuranceClaimDTO);
        Claim savedClaim = claimService.makeClaim(propertyInsuranceClaimDTO.toPropertyInsuranceClaim());
        logger.info("saved " + savedClaim);
        return savedClaim;
    }
}
