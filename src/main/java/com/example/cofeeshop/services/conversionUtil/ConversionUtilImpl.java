package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.services.command.MenuCommand;
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
    SaleUtil saleUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        return menuUtil.menuToMenuDTO(menu);
    }

    @Override
    public Menu menuDTOtoMenu(MenuDTO menuDTO) {
        return menuUtil.menuDTOtoMenu(menuDTO);
    }

    @Override
    public MenuListDTO listAllMenusDTO(List<Menu> menus) {
        return menuUtil.listAllMenusDTO(menus);
    }

    @Override
    public Menu menuCommandToMenu(MenuCommand menuCommand) {
        return menuUtil.menuCommandToMenu(menuCommand);
    }

    @Override
    public MenuCommand menuToMenuCommand(Menu menu) {
        return menuUtil.menuToMenuCommand(menu);
    }

    @Override
    public List<MenuCommand> listAllMenusCommand(List<Menu> menus) {
        return menuUtil.listAllMenusCommand(menus);
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

    @Override
    public SaleDTO saleToSaleDTO(Sale sale) {
        return saleUtil.saleToSaleDTO(sale);
    }

    @Override
    public SaleListDTO listAllSales(List<Sale> sales) {
        return saleUtil.listAllSales(sales);
    }

    @Override
    public Sale saleDTOtoSale(SaleDTO saleDTO) {
        return saleUtil.saleDTOtoSale(saleDTO);
    }
}
