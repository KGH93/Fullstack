package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDTO dto, Article article) {
        //예외발생
        if(dto.getId() != null)
            throw new IllegalArgumentException("댓글생성실패! 댓글아이디가 없어야합니다.");
        if(dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("댓글생성실패! 게시글 아이디가 잘못되었습니다.");
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDTO dto) {
        //예외발생
        if(this.id != dto.getId())
            throw new IllegalArgumentException("댓글 수정실패! 잘못된 아이디가 입력되었습니다.");
        //객체를 갱신
        if(dto.getNickname() != null)
            this.nickname = dto.getNickname();
        if(dto.getBody() != null)
            this.body = dto.getBody();
    }
}
