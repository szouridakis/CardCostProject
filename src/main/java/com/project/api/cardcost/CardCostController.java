package com.project.api.cardcost;

import com.project.api.clearingcost.ClearingCost;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/cardcost")
public class CardCostController {
    
    @Autowired
    private final CardCostService cardCostService;

    
    public CardCostController(CardCostService cardCostService) {
        this.cardCostService = cardCostService;
    }

    @PostMapping("/payment-cards-cost")
    public ResponseEntity<ClearingCost> getClearingCostFromPAN(@Valid @RequestBody CardCost cardCost){
        ClearingCost clearingCost = cardCostService.getClearingCostFromPAN(cardCost);
        return ResponseEntity.ok().body(clearingCost);
    }
}
