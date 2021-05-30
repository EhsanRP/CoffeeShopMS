package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodDTO {

    private Long id;

    @InputValidation
    private String name;

    @InputValidation
    private Double unitPrice;

    @InputValidation
    private Double profit;

    @InputValidation
    private Integer servingTime;

    @InputValidation
    private Long categoryId;

    private Instant creationDate;
    private String url;
}
