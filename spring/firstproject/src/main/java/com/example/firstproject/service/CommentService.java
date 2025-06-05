package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDTO;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;


//    public List<CommentDTO> comments(Long articleId) {
//        //조회 : 댓글목록
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        //변환 entity -> dto
//        List<CommentDTO> dtos = new ArrayList<>();
//        for (int i = 0; i < comments.size(); i++){
//            Comment c = comments.get(i);
//            CommentDTO dto = CommentDTO.createCommentDto(c);
//            dtos.add(dto);
//        }
//        // 반환
//        return  dtos;
//    }


    public List<CommentDTO> comments(Long articleId) {
        // 반환
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDTO.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDTO create(Long articleId, CommentDTO dto) {
        // 게시글 조회 및 예외 발생
        Article article = articleRepository.findById(articleId).orElseThrow(()-> new IllegalArgumentException("댓글생성실패! 대상게시글 없음"));
        // 댓글 엔티티 생성
        Comment comment = Comment.createComment(dto, article);
        // 댓글 엔티티를 db로 지정
        Comment created = commentRepository.save(comment);
        // dto로 변경하여 반환
        return  CommentDTO.createCommentDto(created);
    }

    @Transactional
    public CommentDTO update(Long id, CommentDTO dto) {
        // 게시글 조회
        Comment target = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("댓글 수정 실패! 대상댓글 없음"));
        // 댓글 수정
        target.patch(dto);
        // db갱신
        Comment updated = commentRepository.save(target);
        //댓글 엔티티를 dto로 변환 및 반환
        return CommentDTO.createCommentDto(updated);
    }


    public CommentDTO delete(Long id) {
        Comment target = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("댓글 삭제 실패! 대상이 없음"));
        //댓글 삭제
        commentRepository.delete(target);
        //삭제 댓글을 Dto로 반환
        return  CommentDTO.createCommentDto(target);
    }
}
