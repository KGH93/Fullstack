package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //json을 지원하는 컨트롤러
@Slf4j   // log사용할수있게함
public class ArticleApiController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    //get
    @GetMapping("/api/articles")
    public List<Article> index(){
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
        Article created = articleService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.CREATED).body(created) //201
                                 : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //Patch(수정-업데이트)
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto){
        Article updated = articleService.update(id, dto);

        return (updated != null) ? ResponseEntity.status(HttpStatus.CREATED).body(updated)
                                 : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



    //Delete
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id){
        Article deleted = articleService.delete(id);

        return (deleted != null) ? ResponseEntity.status(HttpStatus.OK).build()
                                 : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
