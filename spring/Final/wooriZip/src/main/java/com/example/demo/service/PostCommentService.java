package com.example.demo.service;

import com.example.demo.dto.PostCommentDto;
import com.example.demo.entity.PostComment;
import com.example.demo.repository.PostCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostCommentService {

    private final PostCommentRepository repo;

    public void save(PostCommentDto dto) {
        PostComment entity = PostComment.builder()
                .postId(dto.getPostId())
                .writer(dto.getWriter())
                .content(dto.getContent())
                .build();
        repo.save(entity);
    }

    public List<PostCommentDto> findByPostId(Long postId) {
        return repo.findByPostIdOrderByCreatedAtAsc(postId).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    private PostCommentDto toDto(PostComment c) {
        return PostCommentDto.builder()
                .commentId(c.getCommentId())
                .postId(c.getPostId())
                .writer(c.getWriter())
                .content(c.getContent())
                .createdAt(c.getCreatedAt())
                .build();
    }
}

