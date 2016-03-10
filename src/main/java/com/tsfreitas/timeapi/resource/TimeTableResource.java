package com.tsfreitas.timeapi.resource;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimeTableResource {

	@GET("/?format=json")
	public Call<Map<String, Object>> getTimeZone(@Query("zone") String zone);

}
