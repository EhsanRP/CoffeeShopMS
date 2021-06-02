package com.example.cofeeshop.web.api.v1.advice;

import com.example.cofeeshop.exceptions.BadRequestException;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.services.dto.exceptions.BadRequest;
import com.example.cofeeshop.services.dto.exceptions.NotFound;
import javassist.tools.web.BadHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {HttpClientErrorException.BadRequest.class, BadRequestException.class, BadHttpRequest.class, NumberFormatException.class})
    public ResponseEntity<Object> handleBadRequest() {
        return new ResponseEntity<>(new BadRequest(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFound() {
        return new ResponseEntity<>(new NotFound(), HttpStatus.NOT_FOUND);
    }

}
