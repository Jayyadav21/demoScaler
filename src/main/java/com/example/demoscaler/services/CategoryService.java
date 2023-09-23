package com.example.demoscaler.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {
    String getAllCategories();

    String getProductInCategory(Long id);
}
