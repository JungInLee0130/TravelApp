package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.HelloResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;

@RequiredArgsConstructor
@Component
public class HelloCallerImpl implements HelloCaller{

    private final RetrofitUtils retrofitUtils;

    private final HelloAPI helloAPI;

    @Override
    public String hello() {
        Call<String> call = helloAPI.hello();
        return retrofitUtils.execute(call);
    }

    @Override
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        Call<HelloResponseDto> call = helloAPI.helloDto(name, amount);
        return retrofitUtils.execute(call);
    }
}
