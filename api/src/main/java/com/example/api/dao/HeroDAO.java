package com.example.api.dao;

import com.example.api.component.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroDAO extends JpaRepository<Hero, Long> {
}
