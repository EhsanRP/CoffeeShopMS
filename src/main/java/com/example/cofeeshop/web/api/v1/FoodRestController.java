package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.repositories.FoodRepository;
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
    public FoodListDTO findAllFoods(){
        return foodService.findAllFoods();
    }

    @GetMapping("{foodId}")
    @ResponseStatus(HttpStatus.OK)
    public FoodDTO findById(@PathVariable Long foodId){
        return foodService.findFoodById(foodId);
    }

    @GetMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public FoodDTO createFood(@Valid @RequestBody FoodDTO foodDTO){
        return foodService.createFood(foodDTO);
    }

}
