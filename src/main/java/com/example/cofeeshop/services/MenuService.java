package com.example.cofeeshop.services;

import com.example.cofeeshop.services.command.MenuCommand;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;

public interface MenuService {

    //METHODS FOR RESTFUL SERVICES

    MenuDTO createMenuFromDTO(MenuDTO menuDTO);

    MenuListDTO findAllMenusDTO();

    MenuDTO findMenuDTOById(Long menuId);

    MenuDTO renameMenuDTO(Long menuId, String name);

    MenuDTO addCategoryDTO(Long menuId, List<Long> categories);

    //METHODS FOR RESTFUL SERVICES

    List<MenuCommand> findAllCommands();
}
