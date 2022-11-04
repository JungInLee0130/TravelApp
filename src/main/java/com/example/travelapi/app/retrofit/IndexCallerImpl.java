package com.example.travelapi.app.retrofit;

import com.example.travelapi.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import retrofit2.Call;

@RequiredArgsConstructor
@Component
public class IndexCallerImpl implements IndexCaller {

    private final RetrofitUtils retrofitUtils;

    private final IndexAPI indexAPI;

    @Override
    public String index(Model model, SessionUser user) {
        Call<String> call = indexAPI.index(model, user);
        return retrofitUtils.execute(call);
    }

    @Override
    public String postsSave() {
        Call<String> call = indexAPI.postsSave();
        return retrofitUtils.execute(call);
    }

    @Override
    public String postsUpdate(Long id, Model model) {
        Call<String> call = indexAPI.postsUpdate(id, model);
        return retrofitUtils.execute(call);
    }
}
