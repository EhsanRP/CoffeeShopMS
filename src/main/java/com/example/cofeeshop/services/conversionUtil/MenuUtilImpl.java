package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.repositories.CategoryRepository;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Value
@Service
public class MenuUtilImpl implements MenuUtil {

    CategoryUtil categoryUtil;

    CategoryRepository categoryRepository;

    MenuMapper menuMapper;
    URIUtilImpl uriUtil;

    @Override
    public MenuDTO menuToMenuDTO(Menu menu) {
        var menuDTO = menuMapper.menuToMenuDTO(menu);
        menuDTO.setCategoryListDTO(categoryUtil.listAllCategories(menu.getCategories()));
        menuDTO.setUrl(uriUtil.menuUriBuilder(menuDTO));
        return menuDTO;
    }

    @Override
    public MenuListDTO listAllMenus(List<Menu> menus) {
        List<MenuDTO> dtoList = new ArrayList<>();
        menus.forEach(menu -> dtoList.add(menuToMenuDTO(menu)));
        return new MenuListDTO(dtoList);
    }

    @Override
    public Menu menuDTOtoMenu(MenuDTO menuDTO) {

        var menu = menuMapper.menuDTOtoMenu(menuDTO);

        Set<Long> categoryIdList = new HashSet<>();
        menuDTO.getCategoryListDTO().getCategoryDTOList().forEach(categoryDTO -> categoryIdList.add(categoryDTO.getId()));
        var categoryList = categoryRepository.findAllById(categoryIdList);

        categoryList.forEach(menu::addCategory);

        return menu;
    }

    @Override
    public Set<Menu> menuDTOtoMenu(Set<MenuDTO> menuDTO) {
        return menuDTO.stream().map(this::menuDTOtoMenu).collect(Collectors.toSet());
    }
}
