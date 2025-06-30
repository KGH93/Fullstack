package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PostCommentDto {
    private Long commentId;
    private Long postId;
    private String writer;
    private String content;
    private LocalDateTime createdAt;
}
