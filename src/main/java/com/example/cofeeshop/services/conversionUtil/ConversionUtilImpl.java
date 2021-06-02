package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.FoodMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Value
@Service
public class ConversionUtilImpl implements ConversionUtil {

    MenuMapper menuMapper;
    CategoryMapper categoryMapper;
    FoodMapper foodMapper;
    FoodUtil foodUtil;
    CategoryUtil categoryUtil;
    MenuUtil menuUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        return menuUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuListDTO listAllMenus(List<Menu> menus) {
        return menuUtil.listAllMenus(menus);
    }
}
