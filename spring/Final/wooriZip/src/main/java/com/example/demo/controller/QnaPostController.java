package com.example.demo.controller;

import com.example.demo.dto.QnaPostDto;
import com.example.demo.entity.Users;
import com.example.demo.service.QnaPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/qna")
public class QnaPostController {

    private final QnaPostService qnaPostService;

    /** QnA 글 등록 */
    @PostMapping("/create")
    public String createQna(@ModelAttribute QnaPostDto dto,
                            @AuthenticationPrincipal Users loginUser,
                            @RequestParam Long productId) throws IOException {
        dto.setProductId(productId);
        qnaPostService.saveQnaPost(dto, loginUser);
        return "redirect:/products/" + productId;
    }

    /** QnA 글 수정 */
    @PostMapping("/update/{id}")
    public String updateQna(@PathVariable Long id,
                            @ModelAttribute QnaPostDto dto,
                            @AuthenticationPrincipal Users loginUser) throws IOException {
        qnaPostService.updateQnaPost(id, dto, loginUser);
        return "redirect:/products/" + dto.getProductId();
    }

    /** QnA 글 삭제 */
    @PostMapping("/delete/{id}")
    public String deleteQna(@PathVariable Long id,
                            @AuthenticationPrincipal Users loginUser,
                            @RequestParam Long productId) {
        qnaPostService.deleteQnaPost(id, loginUser);
        return "redirect:/products/" + productId;
    }

    /** QnA 답변 작성 (관리자) */
    @PostMapping("/answer/{qnaId}")
    public String writeAnswer(@PathVariable Long qnaId,
                              @RequestParam String content,
                              @RequestParam Long productId,
                              @AuthenticationPrincipal Users loginUser) {
        qnaPostService.writeAnswer(qnaId, content, loginUser);
        return "redirect:/products/" + productId;
    }
}
