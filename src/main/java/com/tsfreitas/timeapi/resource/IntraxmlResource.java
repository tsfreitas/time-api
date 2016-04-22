package com.tsfreitas.timeapi.resource;

import com.tsfreitas.timeapi.model.Intraxml;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IntraxmlResource {

	@GET("/prod_unico?&out=1&fldprd=prc,id")
	public Call<Intraxml> getIntraResponse(@Query("idu") Long pu);

}
