package com.example.demo.dto;

import com.example.demo.entity.QnaAnswer;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnaAnswerDto {

    private Long id;
    private String content;
    private String adminNickname;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static QnaAnswerDto fromEntity(QnaAnswer answer) {
        return QnaAnswerDto.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .adminNickname(answer.getAdmin() != null ? answer.getAdmin().getNickname() : "관리자")
                .createdAt(answer.getCreatedAt())
                .updatedAt(answer.getUpdatedAt())
                .build();
    }
}
