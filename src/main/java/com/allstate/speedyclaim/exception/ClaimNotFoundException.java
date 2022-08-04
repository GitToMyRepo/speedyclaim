package com.allstate.speedyclaim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClaimNotFoundException extends RuntimeException {
    public ClaimNotFoundException(String message) {
        super(message);
    }

    public ClaimNotFoundException(Integer claimId) {
        this("Claim not found: " + String.valueOf(claimId));
    }
}
