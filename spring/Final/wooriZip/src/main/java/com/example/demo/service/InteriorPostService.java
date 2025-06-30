package com.example.demo.service;

import com.example.demo.dto.InteriorPostDto;
import com.example.demo.entity.InteriorPost;
import com.example.demo.repository.InteriorPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InteriorPostService {

    private final InteriorPostRepository repository;

    /** [1] 게시글 전체 목록 조회 */
    public List<InteriorPostDto> findAll() {
        return repository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /** [2] 게시글 단건 조회 */
    public InteriorPostDto findById(Long id) {
        InteriorPost post = repository.findById(id).orElse(null);
        return post != null ? toDTO(post) : null;
    }

    /** [3] 게시글 저장/수정 */
    public void save(InteriorPostDto dto) {
        InteriorPost post;

        if (dto.getPostId() != null) {
            // 수정
            post = repository.findById(dto.getPostId()).orElse(null);
            if (post == null) return;
            post.setTitle(dto.getTitle());
            post.setContent(dto.getContent());
            if (dto.getFileNames() != null && dto.getFilePaths() != null) {
                post.setFileName(dto.getFileNames());
                post.setFilePath(dto.getFilePaths());
            }
        } else {
            // 새 글 등록
            post = toEntity(dto);
        }

        repository.save(post);
    }

    /** [4] 게시글 삭제 */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /** [5] 조회수 증가 */
    public void increaseViews(Long id) {
        InteriorPost post = repository.findById(id).orElse(null);
        if (post != null) {
            post.setViews(post.getViews() + 1);
            repository.save(post);
        }
    }

    // -----------------------
    // Entity <-> DTO 변환
    // -----------------------
    private InteriorPostDto toDTO(InteriorPost post) {
        List<String> filePathList = null;
        if (post.getFilePath() != null && !post.getFilePath().isEmpty()) {
            filePathList = Arrays.stream(post.getFilePath().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }

        return InteriorPostDto.builder()
                .postId(post.getPostId())
                .title(post.getTitle())
                .content(post.getContent())
                .fileNames(post.getFileName())
                .filePaths(post.getFilePath())
                .filePathList(filePathList)  // 뷰에서 반복문으로 출력
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .userId(post.getUserId())
                .nickname(post.getNickname())
                .liked(post.getLiked())
                .views(post.getViews())
                .build();
    }

    private InteriorPost toEntity(InteriorPostDto dto) {
        return InteriorPost.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .fileName(dto.getFileNames())
                .filePath(dto.getFilePaths())
                .userId(dto.getUserId())
                .nickname(dto.getNickname())
                .liked(0)
                .views(0)
                .build();
    }
}
