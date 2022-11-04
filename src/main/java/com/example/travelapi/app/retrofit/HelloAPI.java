package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.HelloResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HelloAPI {
    @GET("/hello")
    Call<String> hello();

    @GET("/hello/dto/{name}/{amount}")
    Call<HelloResponseDto> helloDto(@Path("name") String name, @Path("amount") int amount);

}
