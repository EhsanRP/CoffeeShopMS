package com.example.cofeeshop.bootstrap;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.repositories.*;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Value
public class BootstrapData implements CommandLineRunner {

    FoodRepository foodRepository;
    MenuRepository menuRepository;
    BillRepository billRepository;
    ItemRepository itemRepository;
    CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        var menu = menuRepository.save(Menu.builder().name("Main Menu").build());
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
