package com.project.api.cardcost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardCostRepository extends JpaRepository<CardCost, Long> {
}
