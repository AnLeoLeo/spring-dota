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
        return heroService.get(id);
    }

    @PostMapping
    @RequestMapping(method = RequestMethod.POST)
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.add(hero);
    }

    @PutMapping("/{id}")
    @RequestMapping(method = RequestMethod.PUT, )
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero hero) {
        return heroService.update(id, hero);
    }

    @PatchMapping("/{id}")
    public Hero patchHero(@PathVariable Long id, @RequestBody String name) {
        return heroService.patch(id, name);
    }

    @DeleteMapping(("/{id}"))
    public void deleteHero(@PathVariable Long id) {
        heroService.delete(id);
    }
}
