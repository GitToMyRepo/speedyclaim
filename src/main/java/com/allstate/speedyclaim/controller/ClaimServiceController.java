package com.allstate.speedyclaim.controller;

import com.allstate.speedyclaim.domain.ClaimInfo;
import com.allstate.speedyclaim.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimServiceController {

    @Autowired
    private ClaimService claimService;

    @GetMapping()
    public List<ClaimInfo> getAllClaims() {
        return claimService.getAllClaims();
    }
}
