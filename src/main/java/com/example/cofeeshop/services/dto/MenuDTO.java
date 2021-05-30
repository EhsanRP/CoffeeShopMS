package com.example.cofeeshop.services.dto;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuDTO {

    private Long id;
    private Instant creationDate;
    private Instant modificationDate;
    private CategoryListDTO categoryListDTO;

    private String url;
}
