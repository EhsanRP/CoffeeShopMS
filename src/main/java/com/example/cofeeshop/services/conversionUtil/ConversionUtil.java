package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;

public interface ConversionUtil {
    MenuDTO menuToMenuDTO(Menu menu);
    MenuListDTO listAllMenus(List<Menu> menus);
}
