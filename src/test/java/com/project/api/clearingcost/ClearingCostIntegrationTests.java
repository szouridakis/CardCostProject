package com.project.api.clearingcost;

import com.project.api.exception.ResourceNotFoundException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClearingCostIntegrationTests {
	@Autowired
	private MockMvc mockMvc;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testRetrieveClearingCostResourceNotFound() throws Exception{

		String countryCode = "BR";

		mockMvc.perform(get("/api/clearingcost/"+countryCode))
				.andExpect(status().isNotFound())
				.andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
				.andExpect(result -> assertEquals("Country: '" + countryCode + "' not found!", Objects.requireNonNull(result.getResolvedException()).getMessage()));

	}

	@Test
	public void testAddClearingCost() throws Exception{

		Map<String,String> requestContents = new HashMap<>();
		requestContents.put("country","CY");
		requestContents.put("cost","6");
		JSONObject requestContentsJSON = new JSONObject(requestContents);
		String expected = "{\"country\":\"CY\",\"cost\":6.0}";

		mockMvc.perform(post("/api/clearingcost")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestContentsJSON.toString()))
				.andExpect(status().isOk())
				.andExpect(result -> assertEquals(expected,result.getResponse().getContentAsString()));

	}

	@Test
	public void testRetrieveClearingCostSuccess() throws Exception{

		String countryCode = "GR";

		String expected = "{\"country\":\"GR\",\"cost\":15.0}";

		mockMvc.perform(get("/api/clearingcost/"+countryCode))
				.andExpect(status().isOk())
				.andExpect(result ->assertEquals(expected, result.getResponse().getContentAsString()));

	}


}
