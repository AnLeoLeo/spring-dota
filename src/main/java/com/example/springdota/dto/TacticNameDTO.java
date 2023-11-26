package com.example.springdota.dto;

import com.example.springdota.component.Tactic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TacticNameDTO {
    private String name;

    public static Tactic toTactic(TacticNameDTO tacticName) {
        return new Tactic(tacticName.getName());
    }
}
