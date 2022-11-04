package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.PostsSaveRequestDto;
import com.example.travelapi.app.dto.PostsUpdateRequestDto;
import com.example.travelapi.domain.posts.Posts;
import com.example.travelapi.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsCallerImplTest {
    @Autowired
    private PostsCallerImpl postsCaller;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    @DisplayName("게시글 저장")
    @WithMockUser(roles= "USER") // 가짜사용자를 추가하는 어노테이션 -> 단, MockMvc에서만 작동
    public void 게시글_저장() {
        PostsSaveRequestDto saveRequestDto = PostsSaveRequestDto.builder()
                .title("안녕하세요")
                .author("JungInLee")
                .content("첫글입니다")
                .build();

        Long saveResponse = postsCaller.save(saveRequestDto);
    }

    @Test
    @DisplayName("게시글 수정")
    @WithMockUser(roles= "USER") // 가짜사용자를 추가하는 어노테이션 -> 단, MockMvc에서만 작동
    public void 게시글_수정() {
        Posts savedPosts = postsRepository.save(Posts.builder()
                .title("title")
                .author("author")
                .content("content")
                .build());

        Long updateId = savedPosts.getId();
        String expectedTitle = "수정글";
        String expectedContent = "수정글입니다";

        PostsUpdateRequestDto updateRequestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        Long updateResponse = postsCaller.update(updateId ,updateRequestDto);
    }
}