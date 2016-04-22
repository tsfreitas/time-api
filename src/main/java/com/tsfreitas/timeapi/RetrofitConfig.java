package com.tsfreitas.timeapi;

import com.tsfreitas.timeapi.resource.IntraxmlResource;
import com.tsfreitas.timeapi.resource.TimeTableResource;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public TimeTableResource getTimeTable(@Value("${endpoint.timetable}") String endpoint,
                                          @Value("${timetable.key}") String key) {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(getInterceptor(key)).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(endpoint).client(client)
                .addConverterFactory(JacksonConverterFactory.create()).build();

        return retrofit.create(TimeTableResource.class);

    }

    @Bean
    public IntraxmlResource getIntraResource() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://intraxml.com.br")
                .addConverterFactory(SimpleXmlConverterFactory.create()).build();

        return retrofit.create(IntraxmlResource.class);
    }

    private Interceptor getInterceptor(String key) {
        return chain -> {
            Request request = chain.request();

            HttpUrl url = request.url();

            url = url.newBuilder(url.url().toString()).addQueryParameter("key", key).build();

            return chain.proceed(request.newBuilder().url(url).build());
        };
    }
}
