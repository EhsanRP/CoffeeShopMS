package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.exceptions.BadRequestException;
import com.example.cofeeshop.services.MenuService;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping({"/api/v1/menus/","/api/v1/menus"})
public class MenuRestController {

    public static final String MENU_BASE_URL = "/api/v1/menus/";
    private final MenuService menuService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MenuListDTO findAllMenus() {
        return menuService.findAllMenus();
    }

    @GetMapping("{menuId}")
    @ResponseStatus(HttpStatus.OK)
    public MenuDTO findMenu(@PathVariable Long menuId) {
        return menuService.findMenuById(menuId);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuDTO createMenu(@RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }


}
