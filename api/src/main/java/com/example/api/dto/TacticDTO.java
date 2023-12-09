package com.example.api.dto;

import com.example.api.entity.Card;
import com.example.api.entity.Tactic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TacticDTO {
    private Long id;
    private String name;
    private List<CardDTO> cards;

    public static TacticDTO fromTacticAndCards(Tactic tactic, List<Card> tacticCards) {
        TacticDTO tacticDTO = new TacticDTO();
        tacticDTO.setId(tactic.getId());
        tacticDTO.setName(tactic.getName());
        List<CardDTO> list = tacticCards.stream().map(CardDTO::fromCard).toList();
        tacticDTO.setCards(list);
        return tacticDTO;
    }
}
