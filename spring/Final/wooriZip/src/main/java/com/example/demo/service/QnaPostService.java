package com.example.demo.service;

import com.example.demo.dto.QnaAnswerDto;
import com.example.demo.dto.QnaPostDto;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QnaPostService {

    private final QnaPostRepository qnaPostRepository;
    private final QnaAnswerRepository qnaAnswerRepository;
    private final ProductRepository productRepository;

    private final String uploadDir = "uploads";

    /** QNA 질문 등록 */
    public void saveQnaPost(QnaPostDto dto, Users loginUser) throws IOException {
        List<String> filePaths = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();

        if (dto.getFiles() != null) {
            for (MultipartFile file : dto.getFiles()) {
                if (!file.isEmpty()) {
                    String uuid = UUID.randomUUID().toString();
                    String fileName = uuid + "_" + file.getOriginalFilename();
                    String fullPath = uploadDir + "/" + fileName;
                    String publicPath = "/uploads/" + fileName;

                    file.transferTo(new File(fullPath));
                    filePaths.add(publicPath);
                    fileNames.add(file.getOriginalFilename());
                }
            }
        }

        QnaPost post = QnaPost.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .filePaths(String.join(",", filePaths))
                .fileNames(String.join(",", fileNames))
                .user(loginUser)
                .product(productRepository.findById(dto.getProductId()).orElse(null))
                .build();

        qnaPostRepository.save(post);
    }

    /** 답변 등록 */
    public void writeAnswer(Long qnaId, String content, Users adminUser) {
        QnaPost post = qnaPostRepository.findById(qnaId).orElseThrow();
        if (post.getAnswer() != null) return;

        QnaAnswer answer = QnaAnswer.builder()
                .content(content)
                .qnaPost(post)
                .admin(adminUser)
                .build();

        qnaAnswerRepository.save(answer);
    }

    /** 질문 삭제 */
    public void deleteQnaPost(Long qnaId, Users loginUser) {
        QnaPost post = qnaPostRepository.findById(qnaId).orElseThrow();
        if (!post.getUser().getId().equals(loginUser.getId())) return;
        qnaPostRepository.delete(post);
    }

    /** 게시글 + 답변 포함 조회 */
    public Page<QnaPostDto> getQnaList(Long productId, Pageable pageable) {
        Page<QnaPost> posts = qnaPostRepository.findByProductId(productId, pageable);

        return posts.map(post -> {
            QnaAnswerDto answerDto = Optional.ofNullable(post.getAnswer())
                    .map(QnaAnswerDto::fromEntity).orElse(null);
            return QnaPostDto.fromEntity(post, answerDto);
        });
    }

    /** 게시글 수정 */
    public void updateQnaPost(Long qnaId, QnaPostDto dto, Users loginUser) throws IOException {
        QnaPost post = qnaPostRepository.findById(qnaId).orElseThrow();
        if (!post.getUser().getId().equals(loginUser.getId())) return;

        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        // 기존 이미지 삭제
        if (post.getFilePaths() != null) {
            Arrays.stream(post.getFilePaths().split(",")).forEach(path -> new File("uploads" + path.replace("/uploads", "")).delete());
        }

        List<String> filePaths = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();

        if (dto.getFiles() != null) {
            for (MultipartFile file : dto.getFiles()) {
                if (!file.isEmpty()) {
                    String uuid = UUID.randomUUID().toString();
                    String fileName = uuid + "_" + file.getOriginalFilename();
                    String fullPath = uploadDir + "/" + fileName;
                    String publicPath = "/uploads/" + fileName;

                    file.transferTo(new File(fullPath));
                    filePaths.add(publicPath);
                    fileNames.add(file.getOriginalFilename());
                }
            }
        }

        post.setFilePaths(String.join(",", filePaths));
        post.setFileNames(String.join(",", fileNames));

        qnaPostRepository.save(post);
    }
}
