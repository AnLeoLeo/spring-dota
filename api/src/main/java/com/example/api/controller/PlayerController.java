package com.example.api.controller;

import com.example.api.component.Player;
import com.example.api.service.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public Page<Player> getList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        return playerService.getList(PageRequest.of(page, Math.min(limit, 1000)));
    }

    @PostMapping
    public Player savePlayer(@RequestBody Player player) {
        return playerService.add(player);
    }
}
