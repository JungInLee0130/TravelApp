package com.example.travelapi.app.retrofit;

import com.example.travelapi.config.auth.LoginUser;
import com.example.travelapi.config.auth.dto.SessionUser;
import org.springframework.ui.Model;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IndexAPI {

    @GET("/")
    Call<String> index(Model model, @LoginUser SessionUser user);

    // 글 등록. posts-save.mustache를 호출
    @GET("/posts/save")
    Call<String> postsSave();

    // 글 수정.
    @GET("/posts/update/{id}")
    Call<String> postsUpdate(@Path("id") Long id, Model model);
}
