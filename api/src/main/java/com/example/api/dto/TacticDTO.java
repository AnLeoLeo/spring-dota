package com.example.api.dto;

import com.example.api.component.Card;
import com.example.api.component.Tactic;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TacticDTO {
    private Long id;
    private String name;
    private List<Card> cards;

    public static TacticDTO fromTacticAndCards(Tactic tactic, List<Card> tacticCards) {
        TacticDTO tacticDTO = new TacticDTO();
        tacticDTO.setId(tactic.getId());
        tacticDTO.setName(tactic.getName());
        tacticDTO.setCards(tacticCards);
        return tacticDTO;
    }
}
