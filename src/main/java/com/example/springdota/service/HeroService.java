package com.example.springdota.service;

import com.example.springdota.component.Hero;
import com.example.springdota.dao.HeroDAO;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HeroService {
    private final HeroDAO heroDAO;

    public HeroService(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    public Hero get(Long id) {
        return find(id).orElseThrow(() -> new EntityNotFoundException("Герой с указанным id не найден"));
    }

    public Hero add(Hero hero) {
        if (find(hero.getId()).isPresent()) {
            throw new EntityExistsException("Герой с указанным id уже существует.");
        }
        return heroDAO.save(hero);
    }

    public Hero replace(Long id, Hero hero) {
        heroDAO.deleteById(id);
        return heroDAO.save(hero);
    }

    public Hero change(Long id, String name) {
        Hero hero = get(id);
        hero.setName(name);
        return heroDAO.save(hero);
    }

    public void delete(Long id) {
        heroDAO.deleteById(id);
    }

    private Optional<Hero> find(Long id) {
        return heroDAO.findById(id);
    }
}
