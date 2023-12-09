package com.example.api.dao;

import com.example.api.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroDAO extends JpaRepository<Hero, Long> {
}
