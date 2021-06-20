package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.services.FoodService;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.FoodListDTO;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Value
@RequestMapping({"/api/v1/foods/", "/api/v1/foods"})
public class FoodRestController {

    public static String FOOD_BASE_URL = "/api/v1/foods/";
    FoodService foodService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public FoodListDTO findAllFoods() {
        return foodService.findAllFoods();
    }

    @GetMapping("{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public FoodDTO findById(@PathVariable Long foodId) {
        return foodService.findFoodById(foodId);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodDTO createFood(@Valid @RequestBody FoodDTO foodDTO) {
        return foodService.createFood(foodDTO);
    }

    @PutMapping("edit/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public FoodDTO editFood(@PathVariable Long foodId, @RequestBody FoodDTO foodDTO) {
        return foodService.editFood(foodId,foodDTO);
    }

    @PutMapping("remove/{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeFood(@PathVariable Long foodId) {
        foodService.removeFood(foodId);
    }
}
