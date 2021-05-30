package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Food;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

public interface MenuService {

    MenuDTO createMenu();

    void addCategory(Long menuId, Category category);

    MenuListDTO findAllMenus();

    MenuDTO findMenuById(Long menuId);
}
