package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.PostsResponseDto;
import com.example.travelapi.app.dto.PostsSaveRequestDto;
import com.example.travelapi.app.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import retrofit2.Call;

@RequiredArgsConstructor
@Component
public class PostsCallerImpl implements PostsCaller {
    private final RetrofitUtils retrofitUtils;

    private final PostsAPI postsAPI;

    @Override
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        Call<Long> call = postsAPI.save(requestDto);
        return retrofitUtils.execute(call);
    }

    @Override
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        Call<Long> call = postsAPI.update(id, requestDto);
        return retrofitUtils.execute(call);
    }

    @Override
    public PostsResponseDto findById(@PathVariable Long id) {
        Call<PostsResponseDto> call = postsAPI.findById(id);
        return retrofitUtils.execute(call);
    }

    @Override
    public Long delete(@PathVariable Long id) {
        Call<Long> call = postsAPI.delete(id);
        return retrofitUtils.execute(call);
    }
}
