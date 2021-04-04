package com.bcp.bootcamp.purple.shoppingsimulator.repository;

import com.bcp.bootcamp.purple.shoppingsimulator.model.PayDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayDayRepository extends JpaRepository<PayDay, Long> {
}
