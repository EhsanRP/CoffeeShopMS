package com.example.cofeeshop.services;

import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;

public interface FoodService {

    FoodDTO findFoodById(Long foodId);

    FoodListDTO findAllFoods();

    FoodDTO createFood(FoodDTO foodDTO);

    FoodDTO editFood(Long foodId, FoodDTO foodDTO);

    void removeFood(Long foodId);
}
