package com.example.springdota.service;

import com.example.springdota.component.Hero;
import com.example.springdota.dao.HeroDAO;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class HeroService {
    private final HeroDAO heroDAO;

    public HeroService(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    public Hero get(Long id) {
        return find(id).orElseThrow(() -> new EntityNotFoundException("Герой с указанным id не найден."));
    }

    public Page<Hero> getList(Pageable pagination) {
        return heroDAO.findAll(pagination);
    }

    public Hero add(Hero hero) {
        if (find(hero.getId()).isPresent()) {
            throw new EntityExistsException("Герой с указанным id уже существует.");
        }
        return heroDAO.save(hero);
    }

    public Hero update(Long id, Hero hero) {
        if (!hero.getId().equals(id)) {
            throw new RuntimeException("Не совпадает id в запросе с id героя");
        }
        return heroDAO.save(hero);
    }

    public Hero patch(Long id, String name) {
        Hero hero = get(id);
        hero.setName(name);
        return heroDAO.save(hero);
    }

    @Transactional
    public void delete(Long id) {
        if (find(id).isEmpty()) {
            throw new EntityExistsException("Герой с указанным id не найден.");
        }
        heroDAO.deleteById(id);
    }

    private Optional<Hero> find(Long id) {
        return heroDAO.findById(id);
    }
}
