package com.example.demoscaler.inheritanceexamples.mappedSuperClass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="ms_mentor")
@PrimaryKeyJoinColumn(name="user_id")
public class Mentor extends User {
    private int numberOfSession;
    private int numberOfMentees;
}
