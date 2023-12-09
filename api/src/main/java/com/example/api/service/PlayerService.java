package com.example.api.service;

import com.example.api.component.Player;
import com.example.api.dao.PlayerDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Component
public class PlayerService {
    private final PlayerDAO playerDAO;

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    public Player get(Long id) {
        return find(id).orElseThrow(() -> new EntityNotFoundException("Игрок с указанным id не найден."));
    }

    public Page<Player> getList(PageRequest pagination) {
        return playerDAO.findAll(pagination);
    }

    public Player add(Player player) {
        return playerDAO.save(player);
    }

    private Optional<Player> find(Long id) {
        return playerDAO.findById(id);
    }
}
