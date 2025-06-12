package BOARD.KGH.service;

import BOARD.KGH.entity.Board;
import BOARD.KGH.entity.Comment;
import BOARD.KGH.entity.Member;
import BOARD.KGH.repository.BoardRepository;
import BOARD.KGH.repository.CommentRepository;
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
