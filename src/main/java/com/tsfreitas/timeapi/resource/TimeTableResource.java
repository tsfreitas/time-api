package com.tsfreitas.timeapi.resource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimeTableResource {

	@GET("/?format=json")
	public Call<Object> getTimeZone(@Query("zone") String zone);

}
