package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.web.api.v1.CategoryRestController;
import com.example.cofeeshop.web.api.v1.FoodRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class URIUtilImpl implements URIUtil {

    @Override
    public String foodUriBuilder(FoodDTO foodDTO) {
        return FoodRestController.FOOD_BASE_URL + foodDTO.getId();
    }

    @Override
    public String categoryUriBuilder(CategoryDTO categoryDTO) {
        return CategoryRestController.Category_BASE_URL + categoryDTO.getId();
    }
}
