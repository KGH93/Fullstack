package com.highgarden.springboot_board.repository;

import com.highgarden.springboot_board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;
    //Mybaties 데이터베이스 연결 및 sql 실행

    public void save(BoardDto boardDto) {
        sql.insert("Board.save", boardDto);
    }

    public void updateHits(Long id) {
        sql.update("Board.updateHits", id);
    }

    public BoardDto findById(Long id) {
        return sql.selectOne("Board.findById", id);
    }

    public void update(BoardDto boardDto) {
        sql.update("Board.update", boardDto);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
