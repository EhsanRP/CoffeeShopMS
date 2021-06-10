package com.example.cofeeshop.bootstrap;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.FoodRepository;
import com.example.cofeeshop.repositories.MenuRepository;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Value
public class BootstrapData implements CommandLineRunner {

    FoodRepository foodRepository;
    MenuRepository menuRepository;
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        var menu = menuRepository.save(new Menu("Italian"));
        var pizzaCategory = Category.builder().name("Pizza").build();
        menu.addCategory(pizzaCategory);
        categoryRepository.save(pizzaCategory);
        menuRepository.save(menu);

        loadFoods(10, pizzaCategory);
    }

    private void loadFoods(int i, Category pizzaCategory) {
        for (int j = 0; j < i; j++) {
            var food = Food.builder().name("Pizza " + i).servingTime(10).unitPrice(10000.00).profit(3000.00).build();
            pizzaCategory.addّFood(food);
            foodRepository.save(food);
        }
        categoryRepository.save(pizzaCategory);
    }

}
