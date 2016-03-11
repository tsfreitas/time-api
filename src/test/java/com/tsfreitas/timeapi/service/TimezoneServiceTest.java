package com.tsfreitas.timeapi.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tsfreitas.timeapi.model.Timezone;
import com.tsfreitas.timeapi.resource.TimeTableResource;

import retrofit2.Call;
import retrofit2.Response;

@RunWith(MockitoJUnitRunner.class)
public class TimezoneServiceTest {

	@InjectMocks
	private TimezoneService service;

	@Mock
	private TimeTableResource timeTableResource;

	@Mock
	private Call<Map<String, String>> call;

	@Test
	public void deveCriarTimezoneCorretamente() throws IOException {
		// GIVEN
		Map<String, String> body = new HashMap<>();
		Mockito.when(timeTableResource.getTimeZone("America/Sao_Paulo")).thenReturn(call);
		Mockito.when(call.execute()).thenReturn(Response.success(body));
		
		body.put("zoneName", "my_zone_name");
		body.put("countryCode", "country_code");
		body.put("gmtOffset", "1234");
		body.put("timestamp", "1000");

		// WHEN
		Timezone timeZone = service.getTimeZone("America", "Sao_Paulo");

		// THEN
		Assert.assertNotNull(timeZone);
		Assert.assertEquals("my_zone_name", timeZone.getZoneName());
		Assert.assertEquals("country_code", timeZone.getCountryCode());

	}

}
