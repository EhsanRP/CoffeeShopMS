package com.example.cofeeshop.web.api.v1;

import lombok.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Value
@RequestMapping({"/api/v1/categories/", "/api/v1/categories"})
public class CategoryRestController {
    public static String Category_BASE_URL = "/api/v1/categories/";
}
