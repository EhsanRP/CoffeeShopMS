package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Slf4j
@Value
@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    MenuRepository menuRepository;
    FoodRepository foodRepository;

    ConversionUtil conversionUtil;

    @Override
    public CategoryListDTO findAllCategories() {
        var categories = new HashSet<>(categoryRepository.findAll());
        return conversionUtil.listAllCategories(categories);
    }

    @Override
    public CategoryDTO findCategoryById(Long categoryId) {
        var category = findById(categoryId);
        return conversionUtil.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        var category = conversionUtil.categoryDTOtoCategory(categoryDTO);
        categoryRepository.save(category);

        return conversionUtil.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO renameCategory(Long categoryId, String name) {
        var category = findById(categoryId);

        if (!name.isEmpty() || !name.isBlank()) {
            category.setName(name);
            categoryRepository.save(category);
        }

        return conversionUtil.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO changeMenu(Long categoryId, Long menuId) {
        var category = findById(categoryId);
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);

        menu.addCategory(category);
        categoryRepository.save(category);
        menuRepository.save(menu);

        return conversionUtil.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO addFood(Long categoryId, List<Long> foodId) {
        var foods = foodRepository.findAllById(foodId);
        var category = findById(categoryId);

        foods.forEach(category::addFood);

        foodRepository.saveAll(foods);
        categoryRepository.save(category);

        return conversionUtil.categoryToCategoryDTO(category);
    }

    @Override
    public void removeCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(NotFoundException::new);
    }
}
