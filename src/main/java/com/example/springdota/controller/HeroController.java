package com.example.springdota.controller;

import com.example.springdota.component.Hero;
import com.example.springdota.service.HeroService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hero")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable Long id) {
        return heroService.getHero(id);
    }

    @PostMapping
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.save(hero);
    }
}
