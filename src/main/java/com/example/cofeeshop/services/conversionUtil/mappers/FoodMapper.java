package com.example.cofeeshop.services.conversionUtil.mappers;

import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.services.dto.FoodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food foodDTOtoFood(FoodDTO foodDTO);

    FoodDTO foodToFoodDTO(Food food);
}
