package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.HelloResponseDto;

public interface HelloCaller {
    String hello();

    HelloResponseDto helloDto(String name, int amount);
}
