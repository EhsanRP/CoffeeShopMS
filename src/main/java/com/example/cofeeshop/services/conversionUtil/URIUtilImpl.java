package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.SaleDTO;
import com.example.cofeeshop.web.api.v1.CategoryRestController;
import com.example.cofeeshop.web.api.v1.FoodRestController;
import com.example.cofeeshop.web.api.v1.MenuRestController;
import com.example.cofeeshop.web.api.v1.SaleRestController;
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
        return CategoryRestController.CATEGORY_REST_BASE_URL + categoryDTO.getId();
    }

    @Override
    public String menuUriBuilder(MenuDTO menuDTO) {
        return MenuRestController.MENU_REST_BASE_URL + menuDTO.getId();
    }

    @Override
    public String saleUriBuilder(SaleDTO saleDTO) {
        return SaleRestController.SALE_BASE_URL + saleDTO.getId();
    }
}
