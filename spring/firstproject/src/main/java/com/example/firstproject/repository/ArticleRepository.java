package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;  //정렬 가능, 페이지나누기 가능
import org.springframework.data.repository.CrudRepository;  //CRUD에 집중됌


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
