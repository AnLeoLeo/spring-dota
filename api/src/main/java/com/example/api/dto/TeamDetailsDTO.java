package com.example.api.dto;

import com.example.api.component.Team;
import lombok.Data;

@Data
public class TeamDetailsDTO {
    private Long id;
    private String name;
    private TacticDTO tactic;

    public static TeamDetailsDTO fromTeamAndTactic(Team team, TacticDTO withCards) {
        TeamDetailsDTO teamDetailsDTO = new TeamDetailsDTO();
        teamDetailsDTO.setId(team.getId());
        teamDetailsDTO.setName(team.getName());
        if (withCards != null) {
            teamDetailsDTO.setTactic(withCards);
        }
        return teamDetailsDTO;
    }
}
