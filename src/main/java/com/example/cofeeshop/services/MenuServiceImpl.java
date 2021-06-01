package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.conversionUtil.URIUtil;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ConversionUtil conversionUtil;
    private final CategoryRepository categoryRepository;
    private final URIUtil uriUtil;

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
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
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
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
        return conversionUtil.menuToMenuDTO(menu);
    }

    @Override
    public MenuDTO updateMenuName(Long menuId, String name) {
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
        if (!name.isEmpty() || !name.isBlank()){
            menu.setName(name);
            menuRepository.save(menu);
        }
        return conversionUtil.menuToMenuDTO(menu);
    }

    private void setDTOLink(MenuDTO menuDTO) {
        menuDTO.setUrl(uriUtil.menuUriBuilder(menuDTO));
    }
}
