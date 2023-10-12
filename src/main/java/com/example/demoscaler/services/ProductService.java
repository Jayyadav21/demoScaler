package com.example.demoscaler.services;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();


    Product getSingleProduct( Long productId);


    Product addNewProduct( ProductDto product);


    Product updateProduct(Long ProductId, Product product);


    Product deleteProduct(Long ProductId);
}
