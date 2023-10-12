package com.example.demoscaler.services;

import com.example.demoscaler.dtos.CategoryDto;
import com.example.demoscaler.dtos.FakeStoreProductDto;
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
    public List<Product> getProductInCategory(String catergoryName) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response=restTemplate.getForEntity("https://fakestoreapi.com/products/category/{catergoryName}",FakeStoreProductDto[].class,catergoryName );

        ArrayList<Product> answer=new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto:response.getBody()) {
            answer.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }


        return answer;
    }
    public Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
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
}