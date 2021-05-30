package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.conversionUtil.mappers.CategoryMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.FoodMapper;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConversionUtilImpl implements ConversionUtil {

    private final MenuMapper menuMapper;
    private final CategoryMapper categoryMapper;
    private final FoodMapper foodMapper;
    private final FoodUtil foodUtil;
    private final CategoryUtil categoryUtil;
    private final MenuUtil menuUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        return menuUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuListDTO listAllMenus(List<Menu> menus) {
        return menuUtil.listAllMenus(menus);
    }
}
