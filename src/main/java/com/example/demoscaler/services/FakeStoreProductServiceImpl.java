package com.example.demoscaler.services;

import com.example.demoscaler.dtos.FakeStoreProductDto;
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
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        List<Product> answer=new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto:response.getBody()) {
            Product product=new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setDescription(fakeStoreProductDto.getDescription());
            Category category=new Category();
            category.setName(fakeStoreProductDto.getCategory());
            product.setImageUrl(fakeStoreProductDto.getImage());
            answer.add(product);

        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,productId);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setImageUrl(fakeStoreProductDto.getImage());
        return product;



    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();
        Product product1=new Product();
        product1.setId(fakeStoreProductDto.getId());
        product1.setTitle(fakeStoreProductDto.getTitle());
        product1.setPrice(fakeStoreProductDto.getPrice());
        product1.setDescription(fakeStoreProductDto.getDescription());
        Category category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product1.setImageUrl(fakeStoreProductDto.getImage());
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