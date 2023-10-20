package com.project.api.cardcost;

import com.project.api.bin.Bin;
import com.project.api.bin.BinService;
import com.project.api.clearingcost.ClearingCost;
import com.project.api.clearingcost.ClearingCostService;
import com.project.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CardCostService {

    @Autowired
    private final CardCostRepository cardCostRepository;
    @Autowired
    private final BinService binService;
    @Autowired
    private final ClearingCostService clearingCostService;

    public CardCostService(CardCostRepository cardCostRepository, BinService binService, ClearingCostService clearingCostService) {
        this.cardCostRepository = cardCostRepository;
        this.binService = binService;
        this.clearingCostService = clearingCostService;
    }

    public void saveOrUpdate(CardCost cardCost) {
        cardCostRepository.save(cardCost);
    }

    public ClearingCost getClearingCostFromPAN(CardCost cardCost) {

        cardCost.setStatus("Pending");
        saveOrUpdate(cardCost);

        String binNumber = cardCost.getCard_number().substring(0, 6);


        ClearingCost clearingCost;

        try {
            ResponseEntity<Bin> bin = binService.getBinDetails(binNumber);
            String countryCode = bin.getBody().getData().getCountry().getCode();
            clearingCost = clearingCostService.getClearingCostDetails(countryCode.toUpperCase())
                    .orElse(clearingCostService.getClearingCostDetails("Others")
                            .orElseThrow(() -> new ResourceNotFoundException("Country: '" + countryCode.toUpperCase()+ "' or '" + "Others" + "' not found!")));

        } catch (HttpClientErrorException ex) {
            cardCost.setStatus(ex.getStatusText());
            saveOrUpdate(cardCost);
            throw ex;
        } catch (Exception ex) {
            cardCost.setStatus(ex.getMessage());
            saveOrUpdate(cardCost);
            throw ex;
        }

        cardCost.setStatus("SUCCESS");
        saveOrUpdate(cardCost);

        return clearingCost;
    }
}
