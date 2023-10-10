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
public class FakeStoreProductServiceImpl implements ProductService{

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> answer=new ArrayList<>();

        for (ProductDto productDto:response.getBody()) {
            Product product=new Product();
            product.setId(productDto.getId());
            product.setTitle(productDto.getTitle());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            Category category=new Category();
            category.setName(productDto.getCategory());
            product.setImageUrl(productDto.getImage());
            answer.add(product);

        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class,productId);

        ProductDto productDto=response.getBody();
        Product product=new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product.setImageUrl(productDto.getImage());
        return product;



    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products",product,ProductDto.class);

        ProductDto productDto=response.getBody();
        Product product1=new Product();
        product1.setId(productDto.getId());
        product1.setTitle(productDto.getTitle());
        product1.setPrice(productDto.getPrice());
        product1.setDescription(productDto.getDescription());
        Category category=new Category();
        category.setName(productDto.getCategory());
        product1.setImageUrl(productDto.getImage());
        return product1;


    }

    @Override
    public Product updateProduct(Long productId,Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long ProductId) {
        return null;
    }
}