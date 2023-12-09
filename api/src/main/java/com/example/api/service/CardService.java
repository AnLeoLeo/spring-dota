package com.example.api.service;

import com.example.api.component.Card;
import com.example.api.component.Tactic;
import com.example.api.dao.CardDAO;
import com.example.api.dto.CardDTO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class CardService {
    private final CardDAO cardDAO;
    private final HeroService heroService;
    private final PlayerService playerService;

    public CardService(
            CardDAO cardDAO,
            HeroService heroService,
            PlayerService playerService
    ) {
        this.cardDAO = cardDAO;
        this.heroService = heroService;
        this.playerService = playerService;
    }

    boolean setCard(Tactic tactic, Integer cardIndex, CardDTO cardDTO) {
        Card card = null;
        for (Card eachCard: cardDAO.findByTactic_Id(tactic.getId())) {
            if (eachCard.getPosition().equals(cardIndex)) {
                card = eachCard;
            } else {
                if (eachCard.getPlayer().getId().equals(cardDTO.getPlayerId())) {
                    throw new RuntimeException("Указанный игрок уже задан для другой карточки в этой тактике.");
                }
                if (eachCard.getHero().getId().equals(cardDTO.getHeroId())) {
                    throw new RuntimeException("Указанный герой уже задан для другой карточки в этой тактике.");
                }
            }
        }

        if (card == null) {
            card = new Card();
        }
        card.setTactic(tactic);
        card.setPosition(cardIndex);
        card.setHero(heroService.get(cardDTO.getHeroId()));
        card.setPlayer(playerService.get(cardDTO.getPlayerId()));
        cardDAO.save(card);
        return true;
    }

    boolean deleteCard(Tactic tactic, Integer cardIndex) {
        Card card = cardDAO.getByTactic_IdAndPosition(tactic.getId(), cardIndex).orElseThrow(() -> new EntityNotFoundException("Карточка с указанным индексом не задана для тактики."));
        cardDAO.deleteById(card.getId());
        return true;
    }

    List<Card> getByTactic(Long id) {
        return cardDAO.findByTactic_Id(id);
    }
}
