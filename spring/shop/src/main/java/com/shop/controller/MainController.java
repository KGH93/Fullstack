package com.shop.controller;

import com.shop.dto.ItemSearchDto;
import com.shop.dto.MainItemDto;
import com.shop.entity.Item;
import com.shop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ItemService itemService;

    @GetMapping("/")
    public String main(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model){  //페이지 번호가 없을수도 있어 Optional
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0, 6);
        //페이지 번호가 있으면 받고, 없으면 0번 한페이지에 3개씩

        Page<MainItemDto> items = itemService.getMainItemPage(itemSearchDto, pageable);
        //검색조건 itemSearchDto, 페이지정보를 전달하여 상품 목록 조회

        model.addAttribute("items", items);
        model.addAttribute("itemSearchDto", itemSearchDto);
        model.addAttribute("maxPage", 5);
        // 페이지 네비게이션에 최대 몇페이지까지 표시할지 설정

        return "main";
    }




}
