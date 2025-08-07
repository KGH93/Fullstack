package com.highgarden.springboot_board.service;

import com.highgarden.springboot_board.dto.BoardDto;
import com.highgarden.springboot_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final SqlSessionTemplate sql;

    public void save(BoardDto boardDto){
        boardRepository.save(boardDto);
    }

    public List<BoardDto> findAll(){
        System.out.println("findAll");
        return sql.selectList("Board.findAll");
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void update(BoardDto boardDto){
        boardRepository.update(boardDto);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
