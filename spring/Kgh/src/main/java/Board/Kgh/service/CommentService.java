package Board.Kgh.service;


import Board.Kgh.entity.Board;
import Board.Kgh.entity.Comment;
import Board.Kgh.entity.Member;
import Board.Kgh.repository.BoardRepository;
import Board.Kgh.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;

    public List<Comment> getComments(Board board){
        return commentRepository.findByBoardOrderByIdAsc(board);
    }

    public void saveComment(Long boardId, String content, Member writer) {
        Board board = boardRepository.findById(boardId).orElseThrow(()->new IllegalArgumentException("게시글 없음"));
            Comment comment = new Comment();
            comment.setContent(content);
            comment.setWriter(writer);
            comment.setBoard(board);
            commentRepository.save(comment);
    }
}
