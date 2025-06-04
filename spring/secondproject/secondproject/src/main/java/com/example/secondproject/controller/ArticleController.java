package com.example.secondproject.controller;

import com.example.secondproject.dto.ArticleDTO;
import com.example.secondproject.entity.Article;
import com.example.secondproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@Slf4j
public class ArticleController {


    @Autowired
    private ArticleRepository articleRepository;



    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }


    @PostMapping("/articles/create")
    public String createArticle(ArticleDTO dto){
        //1. Dto을 Entity로 변환
        Article article = dto.toEntity();
        //2. Repository에서 Entity를 DB에 저장
        Article saved = articleRepository.save(article);  //DB연결을 안해도 메모리에 저장은 됌.
        return "redirect:/articles/" + saved.getId();
    }


    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){  //url에서 id를 변수로 받아옴
        //1. id로 데이터를 가져옴!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 가져온 데이터를 모델에 등록!
        model.addAttribute("article", articleEntity);
        //3. 보여줄 페이지를 설정!\
        return "articles/show";
    }


    @GetMapping("/articles")
    public String index(Model model){
        //1. 모든 Article을 가져온다!
        List<Article> articleEntityList = articleRepository.findAll();
        //2. 가져온 Article 묶음을 뷰로 전달!
        model.addAttribute("articleList", articleEntityList);
        //3. 뷰 페이지를 설정!
        return "articles/index";
    }


    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //모델에 데이터 등록
        model.addAttribute("article",articleEntity);
        return "articles/edit";
    }


    @PostMapping("/articles/update")
    public String update(ArticleDTO dto){
        //1.dto -> entity로 변환
        Article articleEntity = dto.toEntity();
        //2. Entity를 DB에 저장
        //2_1 : DB에서 기존 데이터를 가져옴
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        //2_2 : 기존 데이터가 있으면, 값을 갱신
        if(target != null){
            articleRepository.save(articleEntity);
        }
        //3. 수정 결과 페이지로 리다이렉트
        return "redirect:/articles/" + articleEntity.getId();
    }


    @PostMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        //1: 삭제 대상을 가져옴
        Article target = articleRepository.findById(id).orElse(null);
        //2. 대상을 삭제
        if (target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료되었습니다.");
        }
        //3. 결과 페이지로 리다이렉트
        return "redirect:/articles";
    }
}
