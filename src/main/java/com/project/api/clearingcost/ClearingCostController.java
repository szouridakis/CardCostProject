package com.project.api.clearingcost;

import com.project.api.exception.ResourceNotFoundException;
import com.project.api.exception.ResponseMessage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ClearingCostController {
    @Autowired
    private final ClearingCostService clearingCostService;
    
    public ClearingCostController(ClearingCostService clearingCostService) {
        this.clearingCostService = clearingCostService;
    }

    @GetMapping("/clearingcosts")
    public List<ClearingCost> getAllClearingCosts(){
        return clearingCostService.getAllClearingCosts();
    }

    @GetMapping("/clearingcost/{country}")
    public ResponseEntity<ClearingCost> getClearingCostById(@PathVariable(value="country") String country){
        ClearingCost clearingCostDetails = clearingCostService.getClearingCostDetails(country)
                .orElseThrow(() -> new ResourceNotFoundException("Country: '" + country + "' not found!"));
        return ResponseEntity.ok().body(clearingCostDetails);
    }
    @PostMapping("/clearingcost")
    public ResponseEntity<ClearingCost> addClearingCost(@Valid @RequestBody ClearingCost clearingCost){
        clearingCostService.saveOrUpdate(clearingCost);
        return ResponseEntity.ok().body(clearingCost);
    }

    @PutMapping("/clearingcost/{country}")
    public ResponseEntity<ClearingCost> updateClearingCost(@PathVariable (value="country") String country,
                                                        @RequestBody ClearingCost clearingCost){
        ClearingCost updatedClearingCost = clearingCostService.getClearingCostDetails(country)
                .orElseThrow(() -> new ResourceNotFoundException("Country: '" + country + "' not found!"));

        updatedClearingCost.setCost(clearingCost.getCost());
        clearingCostService.saveOrUpdate(updatedClearingCost);
        return ResponseEntity.ok().body(updatedClearingCost);
    }

    @DeleteMapping("/clearingcost/{country}")
    public ResponseEntity<Object> deleteClearingCost(@PathVariable(value="country") String country){

        clearingCostService.getClearingCostDetails(country)
                .orElseThrow(() -> new ResourceNotFoundException("Country: '" + country + "' not found!"));

        clearingCostService.deleteClearingCost(country);
        ResponseMessage responseMessage= new ResponseMessage(new Date(),"SUCCESS",HttpStatus.OK,HttpStatus.OK.value());
        return ResponseEntity.ok().body(responseMessage);
    }

}
