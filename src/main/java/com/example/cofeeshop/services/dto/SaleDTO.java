package com.example.cofeeshop.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SaleDTO {

    private Long id;

    private Long foodId;
    private Integer quantity;

    private String url;
}
