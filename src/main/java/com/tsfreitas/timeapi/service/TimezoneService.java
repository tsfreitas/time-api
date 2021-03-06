package com.tsfreitas.timeapi.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsfreitas.timeapi.model.Timezone;
import com.tsfreitas.timeapi.resource.TimeTableResource;

@Service
public class TimezoneService {

	private TimeTableResource timeTableResource;

	private static final String TIMEZONE_PATTERN = "%s/%s";

	@Autowired
	public TimezoneService(TimeTableResource timeTableResource) {
		this.timeTableResource = timeTableResource;
	}

	public Timezone getTimeZone(String region, String area) throws IOException {
		String timezone = String.format(TIMEZONE_PATTERN, region, area);

		Map<String, String> makeRequest = makeRequest(timezone);

		return new Timezone(makeRequest.get("zoneName"), makeRequest.get("countryCode"), makeRequest.get("gmtOffset"),
				makeRequest.get("timestamp"));

	}

	private Map<String, String> makeRequest(String timezone) throws IOException {
		return timeTableResource.getTimeZone(timezone).execute().body();
	}

}
