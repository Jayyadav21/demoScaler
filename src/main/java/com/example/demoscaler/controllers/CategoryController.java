package com.example.demoscaler.controllers;

import com.example.demoscaler.dtos.CategoryDto;
import com.example.demoscaler.models.Category;
import com.example.demoscaler.models.Product;
import com.example.demoscaler.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }


    @GetMapping()
    public ResponseEntity<List<String>> getAllCategories() {

        ResponseEntity<List<String>> response=new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<Product>> getProductInCategory(@PathVariable("categoryName") String categoryName) {
           ResponseEntity<List<Product>> response=new ResponseEntity<>(categoryService.getProductInCategory(categoryName),HttpStatus.OK);

        return response;
    }
}
