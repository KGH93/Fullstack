package Board.Kgh.service;


import Board.Kgh.dto.BoardDTO;
import Board.Kgh.entity.Board;
import Board.Kgh.entity.Member;
import Board.Kgh.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(()-> new NoSuchElementException("해당게시글없음"));
    }

    public void update(Long id, BoardDTO dto) {
        Board board = findById(id);
        board.setTitle(dto.getTitle());
        board.setContent(dto.getContent());
        boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public List<Board> findByWriter(Member writer) {
        return boardRepository.findByWriter(writer);
    }
}
