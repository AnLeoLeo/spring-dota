package com.example.springdota.dao;

import com.example.springdota.component.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CardDAO extends JpaRepository<Card, Long> {
    List<Card> findByTactic_Id(Long tacticId);
    Optional<Card> getByTactic_IdAndPosition(Long tacticId, Integer cardIndex);
}
