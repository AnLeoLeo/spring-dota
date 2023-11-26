package com.example.api.dao;

import com.example.api.component.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player, Long> {
}
