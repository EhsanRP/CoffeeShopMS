package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.FoodMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import com.example.cofeeshop.services.dto.*;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Value
@Service
public class ConversionUtilImpl implements ConversionUtil {

    MenuMapper menuMapper;
    CategoryMapper categoryMapper;
    FoodMapper foodMapper;
    FoodUtil foodUtil;
    CategoryUtil categoryUtil;
    MenuUtil menuUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        return menuUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuListDTO listAllMenus(List<Menu> menus) {
        return menuUtil.listAllMenus(menus);
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        return categoryUtil.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryListDTO listAllCategories(Set<Category> categories) {
        return categoryUtil.listAllCategories(categories);
    }

    @Override
    public FoodDTO foodToFoodDTO(Food food) {
        return foodUtil.foodToFoodDTO(food);
    }



    @Override
    public Menu menuDTOtoMenu(MenuDTO menuDTO) {
        return menuUtil.menuDTOtoMenu(menuDTO);
    }

    @Override
    public Food foodDTOtoFood(FoodDTO foodDTO) {
        return foodUtil.foodDTOtoFood(foodDTO);
    }

    @Override
    public Category categoryDTOtoCategory(CategoryDTO categoryDTO) {
        return categoryUtil.categoryDTOtoCategory(categoryDTO);
    }

    @Override
    public FoodListDTO listAllFoods(Set<Food> foods) {
        return foodUtil.listAllFoods(foods);
    }
}
