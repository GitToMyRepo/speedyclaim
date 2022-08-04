package com.allstate.speedyclaim.service;

import com.allstate.speedyclaim.data.ClaimRepository;
import com.allstate.speedyclaim.domain.*;
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

        Claim c1 = new MotorInsuranceClaim(101, "Ada", LocalDate.now(), BigDecimal.valueOf(391), "reason", "desc", "Toyota", "Argo", 2004);
        Claim c2 = new PetInsuranceClaim(102, "Bob", LocalDate.now().minusWeeks(5), BigDecimal.valueOf(392), "reason", "desc", "Cat", "Abyssinian");
        Claim c3 = new PropertyInsuranceClaim(103, "Clare", LocalDate.now().minusYears(7), BigDecimal.valueOf(393), "reason", "desc", "3 High Street");
        Claim c4 = new PetInsuranceClaim(102, "David", LocalDate.now().minusYears(2).minusDays(5).plusMonths(3), BigDecimal.valueOf(394), "reason", "desc", "dog", "Aidi");

        this.claimRepository.save(c1);
        this.claimRepository.save(c2);
        this.claimRepository.save(c3);
        this.claimRepository.save(c4);
    }
}
