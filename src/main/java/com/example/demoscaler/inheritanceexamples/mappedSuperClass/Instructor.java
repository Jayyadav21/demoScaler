package com.example.demoscaler.inheritanceexamples.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_instructor")
@PrimaryKeyJoinColumn(name="user_id")
public class Instructor extends User {
    private  boolean isHandsome;
}
