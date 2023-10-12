package com.example.demoscaler.controllers;

import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Category;
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
    @PatchMapping("/{productId}")
    public Product updateProduct(@RequestBody ProductDto productDto,@PathVariable("productId") Long productId) {
        Product product=new Product();
        product.setId(productDto.getId());
        product.setPrice(productDto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());


        return productService.updateProduct(productId,product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);


    }
}
