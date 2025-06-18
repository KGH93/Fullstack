package  Board.Kgh.repository;

import Board.Kgh.entity.Board;
import Board.Kgh.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardOrderByIdAsc(Board board);
}
