package com.example.demoscaler.services;

import com.example.demoscaler.dtos.CategoryDto;
import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Category;
import com.example.demoscaler.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreCatergoryServiceImpl implements CategoryService{

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreCatergoryServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<String> getAllCategories() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<String[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products/categories",String[].class );

        String[] categories=response.getBody();

        return Arrays.asList(categories);

    }

    @Override
    public List<Product> getProductInCategory(Long catergoryId) {
        return null;
    }
}