package com.example.demoscaler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@Entity
public class Product extends BaseModel{

    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
}
