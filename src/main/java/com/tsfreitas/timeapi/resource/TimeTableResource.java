package com.tsfreitas.timeapi.resource;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimeTableResource {

	// http://api.timezonedb.com/?zone=Australia/Melbourne&key=NELQKJ8YF4YG&format=json

	@GET("/?format=json")
	public Call<Object> getTimeZone(@Query("zone") String zone);

}
