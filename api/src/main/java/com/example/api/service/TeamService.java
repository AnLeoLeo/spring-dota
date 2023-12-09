package com.example.api.service;

import com.example.api.component.Tactic;
import com.example.api.component.Team;
import com.example.api.dao.TeamDAO;
import com.example.api.dto.TeamDTO;
import com.example.api.dto.TeamDetailsDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamDAO teamDAO;
    private final TacticService tacticService;

    public TeamService(TeamDAO teamDAO, TacticService tacticService) {
        this.teamDAO = teamDAO;
        this.tacticService = tacticService;
    }

    public TeamDetailsDTO getDetails(Long id) {
        Team team = find(id).orElseThrow(() -> new EntityNotFoundException("Команда с указанным id не найдена."));
        if (team.getTactic() == null) {
            return TeamDetailsDTO.fromTeamAndTactic(team, null);
        } else {
            return TeamDetailsDTO.fromTeamAndTactic(team, tacticService.getWithCards(team.getTactic().getId()));
        }
    }

    public Team add(TeamDTO teamDTO) {
        if (find(teamDTO.getId()).isPresent()) {
            throw new EntityExistsException("Команда с указанным id уже существует.");
        }

        return saveTeam(teamDTO);
    }

    public Team update(Long id, TeamDTO teamDTO) {
        if (!teamDTO.getId().equals(id)) {
            throw new RuntimeException("Не совпадает id в запросе с id команды");
        }

        return saveTeam(teamDTO);
    }

    private Optional<Team> find(Long id) {
        return teamDAO.findById(id);
    }

    private Team saveTeam(TeamDTO teamDTO) {
        Tactic tactic = null;
        if (teamDTO.getTacticId() != null) {
            tactic = tacticService.get(teamDTO.getTacticId());
        }

        return teamDAO.save(TeamDTO.toTeamWithTactic(teamDTO, tactic));
    }
}
