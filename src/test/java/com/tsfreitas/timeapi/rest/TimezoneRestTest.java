package com.tsfreitas.timeapi.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.tsfreitas.timeapi.model.Timezone;
import com.tsfreitas.timeapi.service.TimezoneService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TimezoneRestTest {

	@InjectMocks
	private TimezoneRest timezoneRest;

	@Mock
	private TimezoneService timezoneService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(timezoneRest).build();
	}
	
	@Test
	public void deveRetornarRespostaCorretaNoServico() throws Exception {
		// GIVEN
		Timezone timezone = new Timezone("America/Sao_Paulo", "BR", "-3600", "1457614013");
		Mockito.when(timezoneService.getTimeZone("America", "Sao_Paulo")).thenReturn(timezone);
		
		// WHEN
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/timezone/America/Sao_Paulo"));
		
		// THEN
		resultActions
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(MockMvcResultMatchers.jsonPath("$.zoneName").value("America/Sao_Paulo"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.countryCode").value("BR"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.offset").value("GMT-1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.timeDate").value("Thu Mar 10 09:46:53 BRT 2016"))
			.andDo(MockMvcResultHandlers.print());
		
	}

}
