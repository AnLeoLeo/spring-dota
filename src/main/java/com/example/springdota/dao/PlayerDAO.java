package com.example.springdota.dao;

import com.example.springdota.component.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDAO extends JpaRepository<Player, Long> {
}
