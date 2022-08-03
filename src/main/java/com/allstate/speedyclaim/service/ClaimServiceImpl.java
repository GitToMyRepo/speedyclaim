package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.ClaimRepository;
import com.allstate.speedyclaim.domain.ClaimInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public List<ClaimInfo> getAllClaims() {
        System.out.println("Entering getAllClaims");
        System.out.println("returning " + this.claimRepository.findAll());
        return this.claimRepository.findAll();
    }
}
