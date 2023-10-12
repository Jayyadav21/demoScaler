package com.example.demoscaler.services;

import com.example.demoscaler.models.Category;
import com.example.demoscaler.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    List<String> getAllCategories();

    List<Product> getProductInCategory(String catergoryName);
}
