package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;
import java.util.Set;

public interface MenuUtil {
    MenuDTO menuToMenuDTO(Menu menu);

    MenuListDTO listAllMenus(List<Menu> menus);

    Menu menuDTOtoMenu(MenuDTO menuDTO);

    Set<Menu> menuDTOtoMenu(Set<MenuDTO> menuDTO);
}
