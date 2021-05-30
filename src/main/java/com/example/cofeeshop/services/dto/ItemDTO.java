package com.example.cofeeshop.services.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDTO {
    private Long id;
    private Double price;
    private Integer quantity;
    private Long foodId;
    private Long billId;

    private String url;
}
