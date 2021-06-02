package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.MenuDTO;

public interface URIUtil {
    String foodUriBuilder(FoodDTO foodDTO);

    String categoryUriBuilder(CategoryDTO categoryDTO);

    String menuUriBuilder(MenuDTO menuDTO);
}
