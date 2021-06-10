package com.example.cofeeshop.services;

import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;

public interface FoodService {

    FoodDTO findFoodById(Long foodId);

    FoodListDTO findAllFoods();

    FoodDTO createFood(FoodDTO foodDTO);

    FoodDTO editFoodName(Long foodId, String name);

    FoodDTO editFoodPrice(Long foodId, Double price);

    FoodDTO editFoodProfit(Long foodId, Double profit);

    FoodDTO setFoodCategory(Long foodId, Long categoryId);

    void removeFood(Long foodId);
}
