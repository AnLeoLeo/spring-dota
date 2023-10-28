package com.example.springdota.dao;

import com.example.springdota.component.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroDAO extends JpaRepository<Hero, Long> {
}
