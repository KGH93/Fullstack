package loginBoard.board2.service;

import loginBoard.board2.dto.BoardDTO;
import loginBoard.board2.entity.Board;
import loginBoard.board2.entity.Member;
import loginBoard.board2.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board create(BoardDTO dto, Member writer) {
        Board board = new Board();
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        board.setWriter(writer);
        return boardRepository.save(board);
    }

    public List<Board> list() {
        return boardRepository.findAllByOrderByIdDesc();
    }
}
