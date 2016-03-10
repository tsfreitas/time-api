package com.tsfreitas.timeapi.model;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TimezoneTest {

	@Test
	public void deveCriarObjetoCorretamente() throws JsonProcessingException {
		// GIVEN
		String countryCode = "AU";
		String zoneName = "Australia/Melbourne";
		String gmtOffset = "39600";
		String timestamp = "1457614013";

		// WHEN
		Timezone timezone = new Timezone(zoneName, countryCode, gmtOffset, timestamp);

		// THEN
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

		Assert.assertEquals(
				"{\"zoneName\":\"Australia/Melbourne\",\"countryCode\":\"AU\",\"offset\":\"GMT+11\",\"timeDate\":\"Thu Mar 10 09:46:53 BRT 2016\"}",
				mapper.writeValueAsString(timezone));
	}

}
