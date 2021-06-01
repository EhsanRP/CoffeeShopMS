package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.domain.Menu;
import com.example.cofeeshop.services.MenuService;
import com.example.cofeeshop.services.dto.MenuDTO;
import com.example.cofeeshop.services.dto.MenuListDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public MenuDTO createMenu(@Valid @RequestBody Menu menu) {
        return menuService.createMenu(menu);
    }

    @PutMapping("update/{menuId}/name")
    public MenuDTO updateMenu(
            @PathVariable Long menuId,
            @RequestParam(required = false) String name) {
        return menuService.updateMenuName(menuId,name);
    }

    @PutMapping("update/{menuId}/addCategory")
    public MenuDTO addCategory(
            @PathVariable Long menuId,
            @RequestParam(required = false) List<Long> categories) {
        return menuService.addCategory(menuId,categories);
    }
}
