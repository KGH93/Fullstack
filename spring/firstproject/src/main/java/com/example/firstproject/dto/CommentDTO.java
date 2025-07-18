package com.example.firstproject.dto;

import com.example.firstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDTO {
    private Long id;
    @JsonProperty("article_id")
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDTO createCommentDto(Comment comment) {
        return new CommentDTO(comment.getId(),
                              comment.getArticle().getId(),
                              comment.getNickname(),
                              comment.getBody()
        );
    }
}
