package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;

import java.util.Set;

public interface CategoryUtil {
    CategoryDTO categoryToCategoryDTO(Category category);
    CategoryListDTO listAllCategories(Set<Category> categories);
}
