package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.*;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.FoodMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConversionUtilImpl implements ConversionUtil {

    private final MenuMapper menuMapper;
    private final CategoryMapper categoryMapper;
    private final FoodMapper foodMapper;
    private final FoodUtil foodUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        var menuDTO = menuMapper.menuToMenuDTO(menu);

        var categoryList = menu.getCategories();

        List<CategoryDTO> tempCategoryDTOList = new ArrayList<>();

        categoryList.forEach(category -> {
            var categoryDTO = categoryMapper.categoryToCategoryDTO(category);
            categoryDTO.setFoodListDTO(foodUtil.listAllFoods(category.getFoods()));

            tempCategoryDTOList.add(categoryDTO);
        });

        var categoryDTOList = new CategoryListDTO(tempCategoryDTOList);

        menuDTO.setCategoryListDTO(categoryDTOList);

        return menuDTO;
    }
}
