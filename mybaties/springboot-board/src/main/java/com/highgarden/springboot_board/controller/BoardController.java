package com.highgarden.springboot_board.controller;

import com.highgarden.springboot_board.dto.BoardDto;
import com.highgarden.springboot_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public void save(BoardDto boardDto){
        boardService.save(boardDto);
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDto> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        //조회수 처리
        boardService.updateHits(id);
        //상세내용 가져오기
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "detail";
    }

    //수정버튼 클릭시 수정화면으로 넘어가도록 하는 메서드(GET)
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "update";
    }
    //DB에 실절적으로 수정내용을 요청하는 메서드(POST)
    @PostMapping("/update/{id}")
    public String update(BoardDto boardDto, Model model){
        //update요청
        boardService.update(boardDto);
        //findById로 수정된 내용을 다시조회
        BoardDto dto = boardService.findById(boardDto.getId());
        model.addAttribute("board", dto);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/list";
    }
}
