package com.example.springdota.component;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Tactic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Tactic() {
    }

    public Tactic(String name) {
        this.name = name;
    }
}
