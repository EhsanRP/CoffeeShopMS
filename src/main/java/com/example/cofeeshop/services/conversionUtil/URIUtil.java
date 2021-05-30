package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.FoodDTO;

public interface URIUtil {
    String foodUriBuilder(FoodDTO foodDTO);
    String categoryUriBuilder(CategoryDTO categoryDTO);
}
