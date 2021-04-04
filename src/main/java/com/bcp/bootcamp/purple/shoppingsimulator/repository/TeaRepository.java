package com.bcp.bootcamp.purple.shoppingsimulator.repository;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends JpaRepository<Tea, Long> {
}
