package com.example.cofeeshop.services;

import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;

import java.util.List;

public interface CategoryService {

    CategoryListDTO findAllCategories();

    CategoryDTO findCategoryById(Long categoryId);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO renameCategory(Long categoryId, String name);

    CategoryDTO changeMenu(Long categoryId, Long menuId);

    CategoryDTO addFood(Long categoryId, List<Long> FoodId);

    void removeCategory(Long categoryId);

}
