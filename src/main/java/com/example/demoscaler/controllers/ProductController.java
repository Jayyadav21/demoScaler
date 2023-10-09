package com.example.demoscaler.controllers;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class    ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String getAllProducts() {

        return "Getting All Products";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {

        return "Getting Single Product with id: " + id;
    }
    @PostMapping("")
    public String addNewProduct(@RequestBody ProductDto productDto) {
        return "Adding new Product" +productDto;
    }
    @PutMapping("/{id}")
    public String updateProduct(@RequestBody ProductDto productDto,@PathVariable("id") Long id) {
        return "Updating Product with id: " + id +"/r/n"+productDto ;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {

        return "Deleting Product with id: " + id;
    }
}
