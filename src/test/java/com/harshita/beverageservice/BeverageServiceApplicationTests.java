package com.harshita.beverageservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harshita.beverageservice.bootstrap.BeverageLoader;
import com.harshita.beverageservice.services.BeverageService;
import com.harshita.beverageservice.web.controller.BeverageController;
import com.harshita.beverageservice.web.model.BeverageDTO;
import com.harshita.beverageservice.web.model.BeverageSizeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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

	@MockBean
	BeverageService beverageService;

	@Test
	void getBeverageById() throws Exception{
		given(beverageService.getById(any())).willReturn(getValidBeverageDto());

		mockMvc.perform(get("/api/v1/beverage/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void saveNewBeverage() throws Exception{
		BeverageDTO beverageDTO = getValidBeverageDto();
		String beverageDtoJson = objectMapper.writeValueAsString(beverageDTO);

		given(beverageService.saveNewBeverage(any())).willReturn(getValidBeverageDto());

		mockMvc.perform(post("/api/v1/beverage" )
				.contentType(MediaType.APPLICATION_JSON)
				.content(beverageDtoJson))
				.andExpect(status().isCreated());
	}

	@Test
	void updateBeverageById() throws Exception{

		given(beverageService.updateBeverage(any(), any())).willReturn(getValidBeverageDto());

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
				.upc(BeverageLoader.BEVERAGE1_UPC)
				.build();
	}

}
