package com.example.springdota.component;

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
    @ManyToOne(fetch = FetchType.EAGER)
    private Tactic tactic;
    @ManyToOne(fetch = FetchType.EAGER)
    private Player player;
    @ManyToOne(fetch = FetchType.EAGER)
    private Hero hero;
}
