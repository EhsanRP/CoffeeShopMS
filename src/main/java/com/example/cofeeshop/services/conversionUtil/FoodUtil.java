package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;

import java.util.Set;

public interface FoodUtil {

    FoodDTO foodToFoodDTO(Food food);

    FoodListDTO listAllFoods(Set<Food> foods);

    Food foodDTOtoFood(FoodDTO foodDTO);

    Set<Food> foodDTOtoFood(Set<FoodDTO> foodDTOS);
}

