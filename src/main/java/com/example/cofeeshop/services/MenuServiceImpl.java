package com.example.cofeeshop.services;

import com.example.cofeeshop.domain.Category;
import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.exceptions.NotFoundException;
import com.example.cofeeshop.repositories.MenuRepository;
import com.example.cofeeshop.services.conversionUtil.ConversionUtil;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import com.example.cofeeshop.web.api.v1.MenuRestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final ConversionUtil conversionUtil;

    @Override
    public MenuDTO createMenu() {
        var menu = menuRepository.save(Menu.builder().build());
        var menuDTO = conversionUtil.menuToMenuDTO(menu);
        setDTOLink(menuDTO);
        return menuDTO;
    }

    @Override
    public void addCategory(Long menuId, Category category) {
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
        menu.addCategory(category);
        menuRepository.save(menu);
    }

    @Override
    public MenuListDTO findAllMenus() {
        var menuList = menuRepository.findAll();
        var dtoList = menuList.stream()
                .map(menu -> {
                    var menuDTO = conversionUtil.menuToMenuDTO(menu);

                    setDTOLink(menuDTO);
                    return menuDTO;
                })
                .collect(Collectors.toList());
        return new MenuListDTO(dtoList);
    }

    @Override
    public MenuDTO findMenuById(Long menuId) {
        var menu = menuRepository.findById(menuId).orElseThrow(NotFoundException::new);
        var menuDTO = conversionUtil.menuToMenuDTO(menu);
        setDTOLink(menuDTO);
        return menuDTO;
    }

    private void setDTOLink(MenuDTO menuDTO) {
        menuDTO.setUrl(MenuRestController.MENU_BASE_URL + menuDTO.getId());
    }
}
