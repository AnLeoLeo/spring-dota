package com.example.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hero {
    @Id
    private Long id;
    private String name;
}
