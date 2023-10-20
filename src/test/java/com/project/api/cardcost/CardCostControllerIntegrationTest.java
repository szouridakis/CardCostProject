package com.project.api.cardcost;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CardCostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetClearingCostFromPAN() throws Exception{
        //given
        Map<String,String> requestContents = new HashMap<>();
        requestContents.put("card_number","30205000");
        JSONObject requestContentsJSON = new JSONObject(requestContents);
        String expected = "{\"country\":\"US\",\"cost\":5.0}";
        //when
        //then
        mockMvc.perform(post("/api/cardcost/payment-cards-cost")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestContentsJSON.toString()))
                .andExpect(status().isOk())
                .andExpect(result -> assertEquals(expected,result.getResponse().getContentAsString()));
    }
}