package com.example.springdota;

import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class Hero {
    int id;
    String name;
    Backpack backpack;

    public Hero(Backpack backpack) {
        Random random = new Random();
        id = random.nextInt(100);
        name = "Sven";
        this.backpack = backpack;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", backpack=" + backpack +
                '}';
    }
}
