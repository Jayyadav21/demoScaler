package com.example.demoscaler.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{
    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductInCategory(Long id) {
        return null;
    }
}
