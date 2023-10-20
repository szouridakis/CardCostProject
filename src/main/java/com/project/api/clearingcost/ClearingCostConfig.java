package com.project.api.clearingcost;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClearingCostConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClearingCostRepository repository){
        return args -> {
           ClearingCost us = new ClearingCost("US",5);
           ClearingCost gr = new ClearingCost("GR",15);
           ClearingCost others = new ClearingCost("Others",10);
           repository.saveAll(List.of(us,gr,others));
        };


    }
}
