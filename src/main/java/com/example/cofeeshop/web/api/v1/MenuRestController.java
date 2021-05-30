package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.services.MenuService;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/api/v1/menus/","/api/v1/menus"})
public class MenuRestController {

    public static final String MENU_BASE_URL = "/api/v1/menus/";
    private final MenuService menuService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MenuListDTO findAllMenus() {
        return menuService.findAllMenus();
    }

}
