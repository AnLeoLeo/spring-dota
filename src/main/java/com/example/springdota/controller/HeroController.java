package com.example.springdota.controller;

import com.example.springdota.component.Hero;
import com.example.springdota.component.HeroListResponse;
import com.example.springdota.service.HeroService;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {
    private final HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping()
    public HeroListResponse getList(
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> limit
    ) {
        return new HeroListResponse(heroService.getList(PageRequest.of(page.orElse(0), limit.orElse(10))));
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
