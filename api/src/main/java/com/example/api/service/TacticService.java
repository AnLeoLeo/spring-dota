package com.example.api.service;

import com.example.api.entity.Tactic;
import com.example.api.dao.TacticDAO;
import com.example.api.dto.CardDTO;
import com.example.api.dto.TacticDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TacticService {
    private final TacticDAO tacticDAO;
    private final CardService cardService;

    public TacticService(
            TacticDAO tacticDAO,
            CardService cardService
    ) {
        this.tacticDAO = tacticDAO;
        this.cardService = cardService;
    }

    public Tactic get(Long id) {
        return find(id).orElseThrow(() -> new EntityNotFoundException("Тактика с указанным id не найдена."));
    }

    @Transactional
    public TacticDTO getWithCards(Long id) {
        Tactic tactic = get(id);
        return TacticDTO.fromTacticAndCards(tactic, tactic.getCardList());
    }

    public Page<Tactic> getList(Pageable pagination) {
        return tacticDAO.findAll(pagination);
    }

    public Page<Tactic> findByName(String name, Pageable pagination) {
        return tacticDAO.findByNameContains(name, pagination);
    }

    public Tactic create(Tactic tactic) {
        return tacticDAO.save(tactic);
    }

    @Transactional
    public boolean setCard(Long id, Integer cardIndex, CardDTO cardDTO) {
        if (cardIndex < 1 || cardIndex > 5) {
            throw new RuntimeException("Недопустимый индекс карточки.");
        }
        return cardService.setCard(get(id), cardIndex, cardDTO);
    }

    @Transactional
    public boolean deleteCard(Long id, Integer cardIndex) {
        return cardService.deleteCard(get(id), cardIndex);
    }

    private Optional<Tactic> find(Long id) {
        return tacticDAO.findById(id);
    }
}
