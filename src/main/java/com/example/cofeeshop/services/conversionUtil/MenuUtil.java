package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.command.MenuCommand;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;

import java.util.List;
import java.util.Set;

public interface MenuUtil {

    //METHODS FOR RESTFUL SERVICES

    MenuDTO menuToMenuDTO(Menu menu);

    Menu menuDTOtoMenu(MenuDTO menuDTO);

    Set<Menu> menuDTOtoMenu(Set<MenuDTO> menuDTO);

    MenuListDTO listAllMenusDTO(List<Menu> menus);

    //METHODS FOR MVC SIDE

    Menu menuCommandToMenu(MenuCommand menuCommand);

    MenuCommand menuToMenuCommand(Menu menu);

    List<MenuCommand> listAllMenusCommand(List<Menu> menus);
}
