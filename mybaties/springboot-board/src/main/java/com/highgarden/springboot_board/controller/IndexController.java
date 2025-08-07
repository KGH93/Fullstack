package com.highgarden.springboot_board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j //log사용하려면 넣어야함
public class IndexController {
    @GetMapping("/")
    public String index(){
        log.info("index메서드 call");
        return "index";
    }

}
