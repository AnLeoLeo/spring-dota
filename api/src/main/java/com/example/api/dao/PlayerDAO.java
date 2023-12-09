package com.example.api.dao;

import com.example.api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player, Long> {
}
