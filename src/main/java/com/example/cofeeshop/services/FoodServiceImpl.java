package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
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
        foodRepository.save(food);

        return conversionUtil.foodToFoodDTO(food);
    }

    @Override
    public FoodDTO editFood(Long foodId, FoodDTO foodDTO) {

        var food = findById(foodId);

        if (foodDTO.getName() != null && !foodDTO.getName().isEmpty() && !foodDTO.getName().isBlank()) {
            food.setName(foodDTO.getName());
        }

        if (foodDTO.getUnitPrice() != null && foodDTO.getUnitPrice() != 0) {
            food.setUnitPrice(foodDTO.getUnitPrice());
        }

        if (foodDTO.getProfit() != null && foodDTO.getProfit() != 0) {
            food.setProfit(foodDTO.getProfit());
        }

        if (foodDTO.getServingTime() != null && foodDTO.getServingTime() != 0) {
            food.setServingTime(foodDTO.getServingTime());
        }

        if (foodDTO.getCategoryId() != null) {
            var category = categoryRepository.findById(foodDTO.getCategoryId()).orElseThrow(NotFoundException::new);
            category.addFood(food);
            categoryRepository.save(category);
        }

        var foodToReturn = foodRepository.save(food);

        return conversionUtil.foodToFoodDTO(foodToReturn);
    }

    @Override
    public void removeFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }

    private Food findById(Long foodId) {
        return foodRepository.findById(foodId).orElseThrow(NotFoundException::new);
    }
}
