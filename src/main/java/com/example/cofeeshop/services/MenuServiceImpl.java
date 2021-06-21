package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.command.MenuCommand;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.conversionUtil.URIUtil;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@Value
public class MenuServiceImpl implements MenuService {

    MenuRepository menuRepository;
    ConversionUtil conversionUtil;
    CategoryRepository categoryRepository;

    URIUtil uriUtil;

    @Override
    public MenuDTO createMenuFromDTO(MenuDTO menuDTO) {
        var menu = conversionUtil.menuDTOtoMenu(menuDTO);
        menuRepository.save(menu);
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuDTO addCategoryDTO(Long menuId, List<Long> categories) {
        var menu = findById(menuId);
        if (categories.isEmpty()) {
            return conversionUtil.menuToMenuDTO(menu);
        }

        var categoryList = categoryRepository.findAllById(categories);
        menu.addAllCategories(categoryList);
        categoryRepository.saveAll(categoryList);
        menuRepository.save(menu);
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuListDTO findAllMenusDTO() {
        var menus = menuRepository.findAll();
        return conversionUtil.listAllMenusDTO(menus);
    }

    @Override
    public MenuDTO findMenuDTOById(Long menuId) {
        var menu = findById(menuId);
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuDTO renameMenuDTO(Long menuId, String name) {
        var menu = findById(menuId);
        if (!name.isEmpty() || !name.isBlank()) {
            menu.setName(name);
            menuRepository.save(menu);
        }
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public List<MenuCommand> findAllCommands() {
        var menus = menuRepository.findAll();
        return conversionUtil.listAllMenusCommand(menus);
    }

    private Menu findById(Long menuId) {
        return menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
    }
}
