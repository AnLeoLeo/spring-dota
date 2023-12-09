package com.example.api.dto;

import com.example.api.entity.Tactic;
import com.example.api.entity.Team;
import lombok.Data;

@Data
public class TeamDTO {
    private Long id;
    private String name;
    private Long tacticId = null;

    public static Team toTeamWithTactic(TeamDTO teamDTO, Tactic tactic) {
        Team team = new Team();
        team.setId(teamDTO.getId());
        team.setName(teamDTO.getName());
        if (tactic != null) {
            team.setTactic(tactic);
        }
        return team;
    }
}
