package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.*;

import java.util.List;
import java.util.Set;

public interface ConversionUtil {

    MenuDTO menuToMenuDTO(Menu menu);

    MenuListDTO listAllMenus(List<Menu> menus);

    CategoryDTO categoryToCategoryDTO(Category category);

    CategoryListDTO listAllCategories(Set<Category> categories);

    FoodDTO foodToFoodDTO(Food food);

    FoodListDTO listAllFoods(Set<Food> foods);
}
