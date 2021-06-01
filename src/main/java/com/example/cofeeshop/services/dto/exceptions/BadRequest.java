package com.example.cofeeshop.services.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.time.Instant;

@AllArgsConstructor
public class BadRequest {
    private final Instant timeStamp = Instant.now();
    private final String status = "400";
    private final String error = "Can not Understand Entered Id. Check if entered Id matches the id you want.";
}