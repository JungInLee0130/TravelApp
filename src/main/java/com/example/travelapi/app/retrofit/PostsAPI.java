package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.PostsResponseDto;
import com.example.travelapi.app.dto.PostsSaveRequestDto;
import com.example.travelapi.app.dto.PostsUpdateRequestDto;
import retrofit2.Call;
import retrofit2.http.*;

public interface PostsAPI {
    // 게시판 등록
    @POST("api/v1/posts")
    Call<Long> save(@Body PostsSaveRequestDto requestDto);

    // 게시판 수정
    @PUT("/api/v1/posts/{id}")
    Call<Long> update(@Path("id") Long Id, @Body PostsUpdateRequestDto requestDto);


    // findById
    @GET("/api/v1/posts/{id}")
    Call<PostsResponseDto> findById(@Path("id") Long id);

    // 게시판 삭제
    @DELETE("/api/v1/posts/{id}")
    Call<Long> delete(@Path("id") Long id);

}
