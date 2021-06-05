package com.example.cofeeshop.web.api.v1.advice;

import com.example.cofeeshop.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Please correct your id input";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFound(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "The resource you're looking for is not here!";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgument(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Please check your input arguments";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

}
