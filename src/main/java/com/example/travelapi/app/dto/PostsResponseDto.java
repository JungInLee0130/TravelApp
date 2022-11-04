package com.example.travelapi.app.dto;

import com.example.travelapi.domain.posts.Posts;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    @SerializedName("id")
    private Long id;
    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private String content;
    @SerializedName("author")
    private String author;


    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
