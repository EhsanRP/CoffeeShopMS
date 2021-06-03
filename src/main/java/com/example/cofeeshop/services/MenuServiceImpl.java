package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.MenuRepository;
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
    public MenuDTO createMenu(Menu menu) {
        menu.init();
        var newMenu = menuRepository.save(menu);
        var menuDTO = conversionUtil.menuToMenuDTO(menu);
        setDTOLink(menuDTO);
        return menuDTO;
    }

    @Override
    public MenuDTO addCategory(Long menuId, List<Long> categories) {
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
    public MenuListDTO findAllMenus() {
        var menus = menuRepository.findAll();
        return conversionUtil.listAllMenus(menus);
    }

    @Override
    public MenuDTO findMenuById(Long menuId) {
        var menu = findById(menuId);
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuDTO renameMenu(Long menuId, String name) {
        var menu = findById(menuId);
        if (!name.isEmpty() || !name.isBlank()) {
            menu.setName(name);
            menuRepository.save(menu);
        }
        return conversionUtil.menuToMenuDTO(menu);
    }

    private Menu findById(Long menuId){
        return menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
    }
    private void setDTOLink(MenuDTO menuDTO) {
        menuDTO.setUrl(uriUtil.menuUriBuilder(menuDTO));
    }
}
