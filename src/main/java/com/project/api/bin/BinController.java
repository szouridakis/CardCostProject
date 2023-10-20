package com.project.api.bin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BinController {

    @Autowired
    private final BinService binService;
    
    public BinController(BinService binService) {
        this.binService = binService;
    }

    @GetMapping("/bin/{binNumber}")
    public ResponseEntity<Bin> getBinFromExternalApi(@PathVariable(value="binNumber") String binNumber){
        return binService.getBinDetails(binNumber);
    }
}
