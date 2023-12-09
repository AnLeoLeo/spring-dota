package com.example.api.dto;

import com.example.api.component.Tactic;
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
