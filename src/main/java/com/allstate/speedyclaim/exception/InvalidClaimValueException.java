package com.allstate.speedyclaim.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidClaimValueException extends RuntimeException {
    public InvalidClaimValueException(String message) {
        super(message);
    }

    public InvalidClaimValueException(String field, String value) {
        this("Invalid claim value: " + field + "|" + value);
    }
}
