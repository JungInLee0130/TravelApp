package com.example.travelapi.app.retrofit;

import com.example.travelapi.config.auth.LoginUser;
import com.example.travelapi.config.auth.dto.SessionUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

public interface IndexCaller {
    String index(Model model, @LoginUser SessionUser user);

    String postsSave();

    String postsUpdate(@PathVariable Long id, Model model);
}
