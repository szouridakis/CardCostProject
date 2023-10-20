package com.project.api.clearingcost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClearingCostService {
    @Autowired
    private final ClearingCostRepository clearingCostRepository;

    public ClearingCostService(ClearingCostRepository clearingCostRepository) {
        this.clearingCostRepository = clearingCostRepository;
    }

    public List<ClearingCost> getAllClearingCosts() {
        return clearingCostRepository.findAll();
    }

    public Optional<ClearingCost> getClearingCostDetails(String issuing_country) {
        return clearingCostRepository.findById(issuing_country);
    }

    public void saveOrUpdate(ClearingCost clearingCost) {
        clearingCostRepository.save(clearingCost);
    }

    public void deleteClearingCost(String country) {
        clearingCostRepository.deleteById(country);
    }
}
