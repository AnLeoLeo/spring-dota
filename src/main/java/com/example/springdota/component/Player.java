package com.example.springdota.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
