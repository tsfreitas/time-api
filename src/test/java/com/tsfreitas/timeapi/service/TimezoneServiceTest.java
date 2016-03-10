package com.tsfreitas.timeapi.service;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.tsfreitas.timeapi.model.Timezone;
import com.tsfreitas.timeapi.resource.TimeTableResource;

@RunWith(MockitoJUnitRunner.class)
public class TimezoneServiceTest {

	
	@InjectMocks
	private TimezoneService service;
	
	@Mock
	private TimeTableResource timeTableResource;
	
	
	@Test
	public void deveCriarTimezoneCorretamente() throws IOException {
		// GIVEN
		
		// WHEN
		Timezone timeZone = service.getTimeZone("America", "Sao_Paulo");
		
		// THEN
		Assert.fail("terminar teste");
		
	}

}
