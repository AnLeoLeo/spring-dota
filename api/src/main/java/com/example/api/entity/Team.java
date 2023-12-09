package com.example.api.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
