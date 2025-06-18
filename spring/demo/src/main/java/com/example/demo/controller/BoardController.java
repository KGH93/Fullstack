package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardJpaService;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/boards")
public class BoardController {

//    @Autowired
//    private BoardService boardService;


    @Autowired
    private BoardJpaService boardJpaService;



    //게시글 목록
    @GetMapping
    public String list(Model model){
        List<Board> boards = boardJpaService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }


    //작성 폼
    @GetMapping("/new")
    public String form(){
        return "board/form";
    }

    @PostMapping
    public String create(@ModelAttribute Board board){
        boardJpaService.save(board);
        return "redirect:/boards"; //새로고침해서 리스트로 감
    }


    //게시글 상세
    @GetMapping("/{id}")
    public String detial(@PathVariable Long id, Model model){
        Board board = boardJpaService.findById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }
}
