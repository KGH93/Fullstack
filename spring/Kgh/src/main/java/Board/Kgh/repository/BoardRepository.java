package BOARD.KGH.repository;

import BOARD.KGH.entity.Board;
import BOARD.KGH.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByIdDesc();
    List<Board> findByWriter(Member writer);
}
