package com.example.cofeeshop.web.api.v1;

import com.example.cofeeshop.services.CategoryService;
import com.example.cofeeshop.services.dto.CategoryDTO;
import com.example.cofeeshop.services.dto.CategoryListDTO;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Value
@RequestMapping({"/api/v1/categories/", "/api/v1/categories"})
public class CategoryRestController {
    public static String CATEGORY_REST_BASE_URL = "/api/v1/categories/";
    CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO findAllCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO findCategoryById(@PathVariable Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("remove/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeCategory(@PathVariable Long categoryId) {
        categoryService.removeCategory(categoryId);
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @PutMapping("/update/{categoryId}/name")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO updateCategory(
            @PathVariable Long categoryId,
            @RequestParam(required = false) String name) {
        return categoryService.renameCategory(categoryId, name);
    }

    @PutMapping("update/{categoryId}/addFood")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO addFood(
            @PathVariable Long categoryId,
            @RequestParam(required = true) List<Long> foods) {
        return categoryService.addFood(categoryId, foods);
    }

    @PutMapping("update/{categoryId}/changeMenu")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO changeMenu(
            @PathVariable Long categoryId,
            @RequestParam(required = true) Long menuId) {
        return categoryService.changeMenu(categoryId, menuId);
    }
}
