package com.example.cofeeshop.services.dto;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BillDTO {

    private Long id;
    private Instant creationDate;
    private Instant completionDate;
    private Double totalPrice;
    private Boolean isApproved;
    private ItemListDTO itemListDTO;

    private String url;
}
