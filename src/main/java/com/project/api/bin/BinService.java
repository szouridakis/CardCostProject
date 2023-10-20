package com.project.api.bin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BinService {
    private final String API_KEY = "5a03cdc4a59f2a24b33c7774a13c8981c33ceb49";
    public ResponseEntity<Bin> getBinDetails(String binNumber) {
        String url = "https://api.bintable.com/v1/" + binNumber + "?api_key=";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url+API_KEY, Bin.class);
    }
}
