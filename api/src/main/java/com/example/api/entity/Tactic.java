package com.example.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Tactic {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "tactic")
    private List<Card> cardList;

    public Tactic() {
    }

    public Tactic(String name) {
        this.name = name;
    }
}
