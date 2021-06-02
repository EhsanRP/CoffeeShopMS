package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDTO {
    private Long id;

    @InputValidation
    private Double price;

    @InputValidation
    private Integer quantity;

    @InputValidation
    private Long foodId;

    private Long billId;
    private Instant creationDate;
    private String url;
}
