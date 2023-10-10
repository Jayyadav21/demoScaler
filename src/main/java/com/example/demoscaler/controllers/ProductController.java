package com.example.demoscaler.controllers;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Product;
import com.example.demoscaler.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class    ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        ResponseEntity<List<Product>> response=new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
        return response;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) {
        ResponseEntity<Product> response=new ResponseEntity<>(productService.getSingleProduct(productId),HttpStatus.OK);

        return response;
    }
    @PostMapping("")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto) {

        Product newProduct=productService.addNewProduct(productDto);
        ResponseEntity<Product> response=new ResponseEntity<>(newProduct, HttpStatus.CREATED);

        return response;
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
