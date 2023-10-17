package com.example.demoscaler.inheritanceexamples.tablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tbc_ta")
public class TA extends User {
    private double averageRating;
}
