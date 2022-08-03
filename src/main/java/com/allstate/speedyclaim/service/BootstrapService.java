package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.ClaimRepository;
import com.allstate.speedyclaim.domain.ClaimInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BootstrapService {
    @Autowired
    private ClaimRepository claimRepository;

    @PostConstruct
    public void initialiseData() {

        if (this.claimRepository.findAll().size() > 0) return;

        ClaimInfo c1 = new ClaimInfo(null, "Motor", "Ada", LocalDate.now(), BigDecimal.valueOf(392), "reason", "desc");
        ClaimInfo c2 = new ClaimInfo(null, "Motor", "Bob", LocalDate.now(), BigDecimal.valueOf(392), "reason", "desc");

        this.claimRepository.save(c1);
        this.claimRepository.save(c2);
    }
}
