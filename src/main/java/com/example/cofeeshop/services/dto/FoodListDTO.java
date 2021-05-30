package com.example.cofeeshop.services.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FoodListDTO {
    private List<FoodDTO> foodDTOList = new ArrayList<>();
}
