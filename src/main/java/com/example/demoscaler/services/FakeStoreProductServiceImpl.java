package com.example.demoscaler.services;

import com.example.demoscaler.dtos.FakeStoreProductDto;
import com.example.demoscaler.dtos.ProductDto;
import com.example.demoscaler.models.Category;
import com.example.demoscaler.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
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

            answer.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));

        }
        return answer;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,productId);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);



    }

    @Override
    public Product addNewProduct(ProductDto product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response=restTemplate.postForEntity("https://fakestoreapi.com/products",product,FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto=response.getBody();

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);


    }

    @Override
    public Product updateProduct(Long productId,Product product) {
          RestTemplate restTemplate=restTemplateBuilder.requestFactory(
                  HttpComponentsClientHttpRequestFactory.class).build();


           FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
           fakeStoreProductDto.setDescription(product.getDescription());
           fakeStoreProductDto.setCategory(product.getCategory().getName());
           fakeStoreProductDto.setImage(product.getImageUrl());
              fakeStoreProductDto.setPrice(product.getPrice());
                fakeStoreProductDto.setTitle(product.getTitle());

                FakeStoreProductDto fakeStoreProductDtoResponse=restTemplate.patchForObject(
                        "https://fakestoreapi.com/products/{id}",
                        fakeStoreProductDto,
                        FakeStoreProductDto.class,
                        productId);


            return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }



    @Override
    public Product deleteProduct(Long productId) {
      return null;
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

