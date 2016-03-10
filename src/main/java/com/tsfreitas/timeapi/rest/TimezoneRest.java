package com.tsfreitas.timeapi.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfreitas.timeapi.service.TimezoneService;

@RestController
@RequestMapping(name = "/timezone", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TimezoneRest {

	private TimezoneService timezoneService;

	@Autowired
	public TimezoneRest(TimezoneService timezoneService) {
		this.timezoneService = timezoneService;
	}

	@RequestMapping("/{zone}/{area}")
	public Object getTimezone(@PathVariable String zone, @PathVariable String area) throws IOException {
		return timezoneService.getTimeZone(zone, area);
	}

}
