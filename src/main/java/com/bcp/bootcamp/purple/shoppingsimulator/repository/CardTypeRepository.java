package com.bcp.bootcamp.purple.shoppingsimulator.repository;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<Card, Long> {
}
