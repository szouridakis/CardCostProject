package com.project.api.clearingcost;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClearingCostRepository extends JpaRepository<ClearingCost, String> {
}
