package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.conversionUtil.URIUtil;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Slf4j
@Value
@Service
public class FoodServiceImpl implements FoodService {

    FoodRepository foodRepository;
    CategoryRepository categoryRepository;

    ConversionUtil conversionUtil;

    URIUtil uriUtil;

    @Override
    public FoodDTO findFoodById(Long foodId) {
        return conversionUtil.foodToFoodDTO(findById(foodId));
    }

    @Override
    public FoodListDTO findAllFoods() {
        var foodList = new HashSet<>(foodRepository.findAll());
        return conversionUtil.listAllFoods(foodList);
    }

    @Override
    public FoodDTO createFood(FoodDTO foodDTO) {
        var food = conversionUtil.foodDTOtoFood(foodDTO);
        food.init();
        foodRepository.save(food);

        var foodToReturn = conversionUtil.foodToFoodDTO(food);
        uriUtil.foodUriBuilder(foodToReturn);

        return foodToReturn;
    }

    @Override
    public FoodDTO editFoodName(Long foodId, String name) {
        var food = findById(foodId);
        if (!name.isEmpty() || !name.isBlank()) {
            food.setName(name);
            foodRepository.save(food);
        }
        return conversionUtil.foodToFoodDTO(food);
    }

    @Override
    public FoodDTO editFoodPrice(Long foodId, Double price) {
        var food = findById(foodId);
        if (price != null) {
            food.setUnitPrice(price);
            foodRepository.save(food);
        }
        return conversionUtil.foodToFoodDTO(food);
    }

    @Override
    public FoodDTO editFoodProfit(Long foodId, Double profit) {
        var food = findById(foodId);
        if (profit != null) {
            food.setProfit(profit);
            foodRepository.save(food);
        }
        return conversionUtil.foodToFoodDTO(food);
    }

    @Override
    public FoodDTO setFoodCategory(Long foodId, Long categoryId) {
        var food = findById(foodId);
        var category = categoryRepository.findById(categoryId).orElseThrow(NotFoundException::new);

        category.addّFood(food);
        categoryRepository.save(category);
        foodRepository.save(food);

        return null;
    }

    @Override
    public void removeFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    private Food findById(Long foodId) {
        return foodRepository.findById(foodId).orElseThrow(NotFoundException::new);
    }
}
