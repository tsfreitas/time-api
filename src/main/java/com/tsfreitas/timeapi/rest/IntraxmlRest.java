package com.tsfreitas.timeapi.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.tsfreitas.timeapi.model.Intraxml;
import com.tsfreitas.timeapi.resource.IntraxmlResource;

/**
 * Created by tsfreitas on 22/04/16.
 */
@RestController
public class IntraxmlRest {

	private IntraxmlResource intraxmlResource;

	@Autowired
	public IntraxmlRest(IntraxmlResource intraxmlResource) {
		this.intraxmlResource = intraxmlResource;
	}

	@RequestMapping(value = "/intraxml")
	public String getIntraResponse(@RequestParam("idu") Long pu) throws IOException {
		Intraxml body = intraxmlResource.getIntraResponse(pu).execute().body();
		return new Gson().toJson(body);
	}
}
