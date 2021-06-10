package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Sale;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.FoodDTO;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.SaleDTO;

public interface URIUtil {
    String foodUriBuilder(FoodDTO foodDTO);

    String categoryUriBuilder(CategoryDTO categoryDTO);

    String menuUriBuilder(MenuDTO menuDTO);

    String saleUriBuilder(SaleDTO saleDTO);
}
