package com.example.demoscaler.controllers;

import com.example.demoscaler.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public String getAllCategories() {
        return "Getting All Categories";
    }

    @GetMapping("/{id}")
    public String getProductInCategory(@PathVariable("id") Long id) {
        return "Getting Product In Category";
    }
}
