package com.example.demo.repository;

import com.example.demo.entity.QnaAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QnaAnswerRepository extends JpaRepository<QnaAnswer, Long> {
    Optional<QnaAnswer> findByQnaPostId(Long qnaPostId);
}
