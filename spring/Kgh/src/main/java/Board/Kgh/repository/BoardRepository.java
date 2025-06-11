package Board.Kgh.repository;


import Board.Kgh.entity.Board;
import Board.Kgh.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByIdDesc();
    List<Board> findByWriter(Member writer);
}
