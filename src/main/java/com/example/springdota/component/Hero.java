package com.example.springdota.component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Entity
@Getter
@Setter
@Scope("prototype")
public class Hero {
    @Id
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
