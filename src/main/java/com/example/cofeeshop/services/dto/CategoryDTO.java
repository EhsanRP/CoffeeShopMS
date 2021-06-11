package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.services.dto.perms.InputValidation;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private Long id;

    @InputValidation
    private String name;

    @InputValidation
    private Long menuId;

    private FoodListDTO foodListDTO = new FoodListDTO();
    private String uri;
}
