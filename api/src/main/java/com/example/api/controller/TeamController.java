package com.example.api.controller;

import com.example.api.entity.Team;
import com.example.api.dto.TeamDTO;
import com.example.api.dto.TeamDetailsDTO;
import com.example.api.service.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/{id}")
    public TeamDetailsDTO get(@PathVariable Long id) {
        return teamService.getDetails(id);
    }

    @PostMapping
    public Team create(@RequestBody TeamDTO team) {
        return teamService.add(team);
    }

    @PutMapping("/{id}")
    public Team update(@PathVariable Long id, @RequestBody TeamDTO team) {
        return teamService.update(id, team);
    }
}
