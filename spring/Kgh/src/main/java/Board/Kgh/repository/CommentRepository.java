package BOARD.KGH.repository;

import BOARD.KGH.entity.Board;
import BOARD.KGH.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardOrderByIdAsc(Board board);
}
