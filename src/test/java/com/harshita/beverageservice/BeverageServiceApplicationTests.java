package com.harshita.beverageservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshita.beverageservice.web.controller.BeverageController;
import com.harshita.beverageservice.web.model.BeverageDTO;
import com.harshita.beverageservice.web.model.BeverageSizeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeverageController.class)
class BeverageServiceApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void getBeverageById() throws Exception{
		mockMvc.perform(get("/api/v1/beverage/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void saveNewBeverage() throws Exception{
		BeverageDTO beverageDTO = getValidBeverageDto();
		String beverageDtoJson = objectMapper.writeValueAsString(beverageDTO);

		mockMvc.perform(post("/api/v1/beverage" )
				.contentType(MediaType.APPLICATION_JSON)
				.content(beverageDtoJson))
				.andExpect(status().isCreated());
	}

	@Test
	void updateBeverageById() throws Exception{
		BeverageDTO beverageDTO = getValidBeverageDto();
		String beverageDtoJson = objectMapper.writeValueAsString(beverageDTO);

		mockMvc.perform(put("/api/v1/beverage/"+UUID.randomUUID().toString() )
				.contentType(MediaType.APPLICATION_JSON)
				.content(beverageDtoJson))
				.andExpect(status().isNoContent());
	}

	BeverageDTO getValidBeverageDto()
	{
		return BeverageDTO.builder()
				.BeverageName("My Beverage")
				.beverageStyle(BeverageSizeEnum.MEDIUM)
				.price(new BigDecimal("200"))
				.upc(121212121212L)
				.build();
	}

}
