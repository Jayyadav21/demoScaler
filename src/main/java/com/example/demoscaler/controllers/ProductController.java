package com.example.demoscaler.controllers;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Product;
import com.example.demoscaler.services.ProductService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(productId),org.springframework.http.HttpStatus.OK);

        return response;
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
