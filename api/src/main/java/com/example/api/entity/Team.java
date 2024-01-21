package com.example.api.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
public class Team {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    private Tactic tactic;
}
