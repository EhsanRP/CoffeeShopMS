package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;
import java.util.Set;

public interface MenuService {

    MenuDTO createMenu(Menu menu);

    MenuListDTO findAllMenus();

    MenuDTO findMenuById(Long menuId);

    MenuDTO updateMenuName(Long menuId, String name);

    MenuDTO addCategory(Long menuId, List<Long> categories);
}
