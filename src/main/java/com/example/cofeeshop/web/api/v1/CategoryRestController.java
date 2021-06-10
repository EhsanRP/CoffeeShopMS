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
    public static String Category_BASE_URL = "/api/v1/categories/";
    CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO findALlCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO findCategoryById(@PathVariable Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @GetMapping("remove/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public String removeCategory(@PathVariable Long categoryId) {
        //TODO FIX METHOD
        categoryService.removeCategory(categoryId);
        return "redirect:/api/v1/categories/";
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

    @PutMapping("update/{categoryId}/addCategory")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO addFood(
            @PathVariable Long categoryId,
            @RequestParam(required = false) List<Long> foods) {
        return categoryService.addFood(categoryId, foods);
    }
}
