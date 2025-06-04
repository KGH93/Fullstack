package com.example.secondproject.dto;

import com.example.secondproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleDTO {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id,title,content);
    }
}

