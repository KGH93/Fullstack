package com.example.demo.dto;

import com.example.demo.entity.QnaPost;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnaPostDto {

    private Long id;

    private String title;
    private String content;

    // 첨부 이미지
    private List<MultipartFile> files;     // 업로드용
    private String fileNames;              // 저장된 파일명들 (a.jpg,b.jpg)
    private String filePaths;              // 저장된 경로들 (/uploads/qna/a.jpg,...)
    private List<String> filePathList;     // 뷰단 출력용

    // 작성자 정보
    private String nickname;
    private String email;

    // 제품 정보
    private Long productId;
    private String productName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 답변
    private QnaAnswerDto answer;

    public static QnaPostDto fromEntity(QnaPost post, QnaAnswerDto answerDto) {
        List<String> filePathList = null;
        if (post.getFilePaths() != null && !post.getFilePaths().isEmpty()) {
            filePathList = Arrays.stream(post.getFilePaths().split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }

        return QnaPostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .fileNames(post.getFileNames())
                .filePaths(post.getFilePaths())
                .filePathList(filePathList)
                .nickname(post.getUser() != null ? post.getUser().getNickname() : "알 수 없음")
                .email(post.getUser() != null ? post.getUser().getEmail() : "")
                .productId(post.getProduct() != null ? post.getProduct().getId() : null)
                .productName(post.getProduct() != null ? post.getProduct().getName() : "알 수 없음")
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .answer(answerDto)
                .build();
    }
}
