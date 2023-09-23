package com.example.demoscaler.services;

import com.example.demoscaler.dtos.ProductDto;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductServiceImpl implements ProductService{
    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public String getSingleProduct(Long id) {
        return null;
    }

    @Override
    public String addNewProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String updateProduct(Long id) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }
}
