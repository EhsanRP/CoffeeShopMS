package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.repositories.FoodRepository;
import lombok.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Value
@RequestMapping({"/api/v1/foods/", "/api/v1/foods"})
public class FoodRestController {
    public static String FOOD_BASE_URL = "/api/v1/foods/";

    FoodRepository foodRepository;

}
