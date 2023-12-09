package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue
    private Long id;
    private Integer position;
    @ManyToOne(fetch = FetchType.LAZY)
    private Tactic tactic;
    @ManyToOne(fetch = FetchType.LAZY)
    private Player player;
    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;
}
