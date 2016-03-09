package com.tsfreitas.timeapi;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tsfreitas.timeapi.resource.TimeTableResource;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {
	
	public static void main(String[] args) throws IOException {
		RetrofitConfig c = new RetrofitConfig();
		
		TimeTableResource timeTable = c.getTimeTable("http://api.timezonedb.com");
		
		System.out.println(timeTable.getTimeZone("America/Sao_Paulo").execute().body());
	}

	@Bean
	public TimeTableResource getTimeTable(@Value("endpoint.timetable") String endpoint) {

		
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
			
			@Override
			public Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				
				HttpUrl url =request.url();
				
				url.q
				
				request.newBuilder().url(url);
				
				return chain.proceed(request);
			}
		}).build();
		
		Retrofit retrofit = new Retrofit.Builder().baseUrl(endpoint)
				.client(client)
				.addConverterFactory(JacksonConverterFactory.create())
				.build();

		return retrofit.create(TimeTableResource.class);

	}
}
