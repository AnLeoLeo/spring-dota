package com.example.api.dto;

import com.example.api.entity.Card;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDTO {
    private Long playerId;
    private Long heroId;

    public static CardDTO fromCard(Card card) {
        CardDTO cardDTO = new CardDTO();
        cardDTO.setHeroId(card.getHero().getId());
        cardDTO.setPlayerId(card.getPlayer().getId());
        return cardDTO;
    }
}
