package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Value
@Service
public class CategoryUtilImpl implements CategoryUtil {

    FoodUtil foodUtil;

    MenuRepository menuRepository;
    FoodRepository foodRepository;

    CategoryMapper categoryMapper;
    URIUtil uriUtil;

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        var categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        categoryDTO.setFoodListDTO(foodUtil.listAllFoods(category.getFoods()));
        categoryDTO.setMenuId(category.getMenu().getId());
        categoryDTO.setUri(uriUtil.categoryUriBuilder(categoryDTO));
        return categoryDTO;
    }

    @Override
    public CategoryListDTO listAllCategories(Set<Category> categories) {
        List<CategoryDTO> dtoList = new ArrayList<>();
        categories.forEach(category -> dtoList.add(categoryToCategoryDTO(category)));
        return new CategoryListDTO(dtoList);
    }

    @Override
    public Category categoryDTOtoCategory(CategoryDTO categoryDTO) {
        var category = categoryMapper.categoryDTOtoCategory(categoryDTO);

        var menu = menuRepository.findById(categoryDTO.getMenuId()).orElseThrow(NotFoundException::new);
        menu.addCategory(category);

        Set<Long> foodIdList = new HashSet<>();
        categoryDTO.getFoodListDTO().getFoodDTOList().forEach(foodDTO -> foodIdList.add(foodDTO.getId()));
        var foods = foodRepository.findAllById(foodIdList);
        foods.forEach(category::addّFood);

        return category;
    }

    @Override
    public Set<Category> categoryDTOtoCategory(Set<CategoryDTO> categories) {
        return categories.stream().map(this::categoryDTOtoCategory).collect(Collectors.toSet());
    }

}
