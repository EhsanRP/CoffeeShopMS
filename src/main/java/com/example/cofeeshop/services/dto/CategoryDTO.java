package com.example.cofeeshop.services.dto;

import com.example.cofeeshop.domain.Menu;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDTO {
    private Long id;

    private Instant creationDate;
    private String name;
    private Long menuId;
    private FoodListDTO foodListDTO;

    private String uri;
}
