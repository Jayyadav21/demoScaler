package com.example.demoscaler.services;

import com.example.demoscaler.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

public interface ProductService {

    String getAllProducts();


    String getSingleProduct( Long id);


    String addNewProduct( ProductDto productDto);


    String updateProduct(Long id);


    String deleteProduct(Long id);
}
