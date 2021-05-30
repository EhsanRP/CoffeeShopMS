package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Food;

public interface FoodService {
    Food createFood(Food food);

    Food editFood(Long foodId, Food food);

    void removeFood(Long foodId);
}
