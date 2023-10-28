package com.example.springdota.service;

import com.example.springdota.component.Hero;
import com.example.springdota.dao.HeroDAO;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroDAO heroDAO;

    public HeroService(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    public Hero getHero(Long id) {
        return heroDAO.findById(id).orElse(null);
    }

    public Hero save(Hero hero) {
        return heroDAO.save(hero);
    }
}
