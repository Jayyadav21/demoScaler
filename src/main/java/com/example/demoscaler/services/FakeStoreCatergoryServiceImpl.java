package com.example.demoscaler.services;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Category;
import com.example.demoscaler.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCatergoryServiceImpl implements CategoryService{


    @Override
    public String getAllCategories() {
        return null;
    }

    @Override
    public String getProductInCategory(Long id) {
        return null;
    }
}