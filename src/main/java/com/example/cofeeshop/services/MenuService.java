package com.example.cofeeshop.services;

import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;

public interface MenuService {

    MenuDTO createMenu(MenuDTO menuDTO);

    MenuListDTO findAllMenus();

    MenuDTO findMenuById(Long menuId);

    MenuDTO renameMenu(Long menuId, String name);

    MenuDTO addCategory(Long menuId, List<Long> categories);


}
