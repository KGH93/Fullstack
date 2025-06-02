package com.example.board01.repository;

import com.example.board01.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//japrepository 쓸때 <엔티티,기준값> 입력해야됌
public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAll();
}
