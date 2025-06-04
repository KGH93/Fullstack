package com.example.secondproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NormalController {
    @GetMapping("/hi") //요청 URL
    public String niceToMeetYou(Model model){
        model.addAttribute("username","jungwon");
        //보여줄 페이지 return
        return "greetings"; // templates/greetings.mustache
    }

    @GetMapping("/bye") //요청 URL
    public String seeYouNext(Model model){
        model.addAttribute("nickname","홍길동");
        //보여줄 페이지 return
        return "goodbye"; // templates/greetings.mustache
    }

}
