package com.bcp.bootcamp.purple.shoppingsimulator.repository;

import com.bcp.bootcamp.purple.shoppingsimulator.model.Fees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRepository extends JpaRepository<Fees, Long> {
}
