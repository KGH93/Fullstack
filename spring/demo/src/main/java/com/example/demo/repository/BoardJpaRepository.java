package com.example.demo.repository;

import com.example.demo.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardJpaRepository extends JpaRepository<Board,Long> {  //crudrepo 에서 +  페이징추가기능이 jparepo
    List<Board> findAll();
}
