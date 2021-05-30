package com.example.cofeeshop.services.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
public class NotFound {
    private final Instant timeStamp = Instant.now();
    private final String status = "404";
    private final String error = "What You're looking for is not found. Entered Id might be wrong";
}
