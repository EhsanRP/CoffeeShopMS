package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryUtilImpl implements CategoryUtil {

    private final FoodUtil foodUtil;

    private final CategoryMapper categoryMapper;
    private final URIUtil uriUtil;

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        var categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        categoryDTO.setFoodListDTO(foodUtil.listAllFoods(category.getFoods()));
        categoryDTO.setUri(uriUtil.categoryUriBuilder(categoryDTO));
        return null;
    }

    @Override
    public CategoryListDTO listAllCategories(Set<Category> categories) {
        List<CategoryDTO> dtoList = new ArrayList<>();
        categories.forEach(category -> dtoList.add(categoryToCategoryDTO(category)));
        return new CategoryListDTO(dtoList);
    }
}
