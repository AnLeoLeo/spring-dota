package com.example.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
