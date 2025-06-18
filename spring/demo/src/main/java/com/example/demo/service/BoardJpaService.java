package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardJpaService {

    @Autowired
    private BoardJpaRepository boardJpaRepository;

    @Transactional
    public void save(Board board) {
        boardJpaRepository.save(board);
    }

    public Board findById(Long id) {
        return boardJpaRepository.findById(id).orElse(null);
    } //findbyid는 옵셔널값으로 처리하던가 throw

    public List<Board> findAll() {
        return boardJpaRepository.findAll();
    } //findall은 서비스에서 오버라이딩

    public void delete(Board board) {
        boardJpaRepository.delete(board);
    }
}
