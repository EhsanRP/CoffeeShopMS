package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;

public interface MenuService {

    MenuDTO createMenu(Menu menu);

    MenuListDTO findAllMenus();

    MenuDTO findMenuById(Long menuId);

    MenuDTO updateMenuName(Long menuId, String name);

    MenuDTO addCategory(Long menuId, List<Long> categories);


}
