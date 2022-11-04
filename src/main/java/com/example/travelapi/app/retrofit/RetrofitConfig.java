package com.example.travelapi.app.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfig {
    private final String baseUrl = "http://10.0.2.2:8080/";

    private static final HttpLoggingInterceptor loggingInterceptor
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private final Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(1, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public Retrofit retrofit(OkHttpClient client) {
        String baseURL = baseUrl;
        return new Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


    // HelloAPI @Bean 등록 -> consider defining a bean of type ~ 오류 해결
    @Bean
    public HelloAPI HelloserverAPIs(Retrofit retrofit) {
        return retrofit.create(HelloAPI.class);
    }

    @Bean
    public IndexAPI IndexserverAPIs(Retrofit retrofit) {
        return retrofit.create(IndexAPI.class);
    }

    @Bean
    public PostsAPI PostsserverAPIs(Retrofit retrofit) {
        return retrofit.create(PostsAPI.class);
    }
}

/*@Bean
    PostsAPI getJsonPlaceHolderAPI() {
        //retrofit 상세 설정
        OkHttpClient client = new OkHttpClient.Builder()
                //서버로 요청하는데 걸리는 시간을 제한 (15초 이내에 서버에 요청이 성공해야한다. (handshake))
                .connectTimeout(15, TimeUnit.SECONDS)
                //서버로 요청이 성공했고, 응답데이터를 받는데 시간을 제한한다. (15초 이내에 응답 데이터를 전달받아야한다)
                .addInterceptor(loggingInterceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
                .create(PostsAPI.class);
    }*/
