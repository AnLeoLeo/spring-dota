package com.example.api.dao;

import com.example.api.component.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDAO extends JpaRepository<Team, Long> {
}
