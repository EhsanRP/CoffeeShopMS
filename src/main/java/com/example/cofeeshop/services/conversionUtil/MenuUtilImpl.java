package com.example.cofeeshop.services.conversionUtil;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.conversionUtil.mappers.MenuMapper;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MenuUtilImpl implements MenuUtil {

    private final CategoryUtil categoryUtil;

    private final MenuMapper menuMapper;
    private final URIUtilImpl uriUtil;

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
}
