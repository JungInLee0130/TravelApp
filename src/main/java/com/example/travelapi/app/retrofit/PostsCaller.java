package com.example.travelapi.app.retrofit;

import com.example.travelapi.app.dto.PostsResponseDto;
import com.example.travelapi.app.dto.PostsSaveRequestDto;
import com.example.travelapi.app.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostsCaller {

    // 게시판 저장
    Long save(@RequestBody PostsSaveRequestDto requestDto);

    // 게시판 수정
    Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto);

    // findById
    PostsResponseDto findById(@PathVariable Long id);

    // 게시글 삭제
    Long delete(@PathVariable Long id);

}
