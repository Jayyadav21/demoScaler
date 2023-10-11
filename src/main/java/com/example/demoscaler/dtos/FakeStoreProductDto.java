package com.example.demoscaler.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto {
    Long id;
    String title;
    Double price;
    String description;
    String image;
    String category;
}
