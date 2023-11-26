package com.example.api.controller;

import com.example.api.component.Hero;
import com.example.api.service.HeroService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping()
    public Page<Hero> getList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        return heroService.getList(PageRequest.of(page, Math.min(limit, 1000)));
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable Long id) {
        return heroService.get(id);
    }

    @PostMapping
    public Hero saveHero(@RequestBody Hero hero) {
        return heroService.add(hero);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
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
