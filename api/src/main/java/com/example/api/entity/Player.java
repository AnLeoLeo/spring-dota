package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Role role = Role.CARRY;
}
