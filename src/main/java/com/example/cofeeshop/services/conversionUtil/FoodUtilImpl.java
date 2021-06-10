package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.FoodMapper;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Value
@Service
public class FoodUtilImpl implements FoodUtil {

    CategoryRepository categoryRepository;

    FoodMapper foodMapper;
    URIUtil uriUtil;

    @Override
    public FoodDTO foodToFoodDTO(Food food) {
        var foodDTo = foodMapper.foodToFoodDTO(food);
        foodDTo.setCategoryId(food.getCategory().getId());
        foodDTo.setUrl(uriUtil.foodUriBuilder(foodDTo));
        return foodDTo;
    }

    @Override
    public FoodListDTO listAllFoods(Set<Food> foods) {
        List<FoodDTO> dtoList = new ArrayList<>();
        foods.forEach(food -> dtoList.add(foodToFoodDTO(food)));
        return new FoodListDTO(dtoList);
    }

    @Override
    public Food foodDTOtoFood(FoodDTO foodDTO) {
        var food = foodMapper.foodDTOtoFood(foodDTO);

        var category = categoryRepository.findById(foodDTO.getCategoryId()).orElseThrow(NotFoundException::new);
        category.addFood(food);

        return food;
    }

    @Override
    public Set<Food> foodDTOtoFood(Set<FoodDTO> foodDTOS) {
        return foodDTOS.stream().map(this::foodDTOtoFood).collect(Collectors.toSet());
    }
}
