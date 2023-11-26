package com.example.api.dao;

import com.example.api.component.Tactic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacticDAO extends JpaRepository<Tactic, Long> {
    Page<Tactic> findByNameContains(String string, Pageable pagination);
}
