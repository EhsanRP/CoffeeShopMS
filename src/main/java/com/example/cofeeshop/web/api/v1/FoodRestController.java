package com.example.cofeeshop.web.api.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/api/v1/foods/","/api/v1/foods"})
public class FoodRestController {
    public static final String FOOD_BASE_URL = "/api/v1/foods/";
}
