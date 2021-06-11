package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SaleDTO {

    private Long id;

    @InputValidation
    private Long foodId;
    @InputValidation
    private Integer quantity;

    private Double unitPrice;
    private Double profit;

    private String url;
}
