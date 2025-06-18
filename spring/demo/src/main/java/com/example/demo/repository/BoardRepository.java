package com.example.demo.repository;

import com.example.demo.domain.Board;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    //jpa
    @PersistenceContext
    private EntityManager em;

    public void save(Board board){
        em.persist(board);
    }

    public Board findById(Long id){
        return em.find(Board.class, id);
    }

    public List<Board> findAll(){
        return em.createQuery("select b from Board b", Board.class)
                .getResultList();
    }

    public void delete(Board board){
        em.remove(board);
    }
}
