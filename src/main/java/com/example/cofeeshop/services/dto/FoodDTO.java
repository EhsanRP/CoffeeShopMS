package com.example.cofeeshop.services.dto;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodDTO {

    private Long id;
    private String name;
    private Double unitPrice;
    private Double profit;
    private Integer servingTime;
    private Instant creationDate;
    private Long categoryId;

    private String url;
}
