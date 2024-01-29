package com.example.api.controller;

import com.example.api.entity.Tactic;
import com.example.api.dto.CardDTO;
import com.example.api.dto.TacticDTO;
import com.example.api.dto.TacticNameDTO;
import com.example.api.service.TacticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tactics")
@Slf4j
public class TacticController {
    private final TacticService tacticService;

    public TacticController(TacticService tacticService) {
        this.tacticService = tacticService;
    }

    @GetMapping
    public Page<Tactic> getList(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {
        return tacticService.getList(PageRequest.of(page, Math.min(limit, 1000)));
    }

    @PostMapping("/search")
    public Page<Tactic> search(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestBody(required = false) TacticNameDTO tacticNameDTO
    ) {
        if (tacticNameDTO == null || tacticNameDTO.getName() == null) {
            throw new RuntimeException("Пустой запрос.");
        } else {
            return tacticService.findByName(tacticNameDTO.getName(), PageRequest.of(page, Math.min(limit, 1000)));
        }
    }

    @GetMapping("/{id}")
    public TacticDTO get(@PathVariable Long id) {
        log.info("get tactic");
        return tacticService.getWithCards(id);
    }

    @PostMapping
    public Tactic create(@RequestBody TacticNameDTO tacticNameDTO) {
        return tacticService.create(TacticNameDTO.toTactic(tacticNameDTO));
    }

    @PutMapping("/{id}/cards/{cardIndex}")
    public boolean setCard(
            @PathVariable Long id,
            @PathVariable Integer cardIndex,
            @RequestBody CardDTO cardDTO
    ) {
        return tacticService.setCard(id, cardIndex, cardDTO);
    }

    @DeleteMapping("/{id}/cards/{cardIndex}")
    public boolean deleteCard(
            @PathVariable Long id,
            @PathVariable Integer cardIndex
    ) {
        return tacticService.deleteCard(id, cardIndex);
    }
}
