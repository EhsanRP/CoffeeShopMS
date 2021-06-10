package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuDTO {

    private Long id;

    @InputValidation
    private String name;

    private CategoryListDTO categoryListDTO;
    private String url;
}
