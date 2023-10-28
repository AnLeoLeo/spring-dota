package com.example.springdota;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("prototype")
public class Backpack {
    int id;

    public Backpack() {
        Random random = new Random();
        id = random.nextInt(100);
    }

    @Override
    public String toString() {
        return "Backpack{" +
                "Backpack version=" + id +
                '}';
    }
}
