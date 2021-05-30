package com.example.cofeeshop.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        log.debug("Exception Caught");
    }

    public BadRequestException(String message) {
        super(message);
        log.debug("Exception Caught");
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
        log.debug("Exception Caught");
    }

    public BadRequestException(Throwable cause) {
        super(cause);
        log.debug("Exception Caught");
    }

    public BadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.debug("Exception Caught");
    }
}
