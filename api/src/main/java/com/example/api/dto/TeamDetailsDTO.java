package com.example.api.dto;

import com.example.api.entity.Team;
import lombok.Data;

@Data
public class TeamDetailsDTO {
    private Long id;
    private String name;
    private TacticDTO tactic;

    public static TeamDetailsDTO fromTeamAndTactic(Team team, TacticDTO tacticWithCards) {
        TeamDetailsDTO teamDetailsDTO = fromTeam(team);
        if (tacticWithCards != null) {
            teamDetailsDTO.setTactic(tacticWithCards);
        }
        return teamDetailsDTO;
    }

    public static TeamDetailsDTO fromTeam(Team team) {
        TeamDetailsDTO teamDetailsDTO = new TeamDetailsDTO();
        teamDetailsDTO.setId(team.getId());
        teamDetailsDTO.setName(team.getName());
        return teamDetailsDTO;
    }
}
