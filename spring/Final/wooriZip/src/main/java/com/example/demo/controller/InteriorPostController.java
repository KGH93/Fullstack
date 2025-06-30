package com.example.demo.controller;

import com.example.demo.dto.InteriorPostDto;
import com.example.demo.dto.PostCommentDto;
import com.example.demo.service.InteriorPostService;
import com.example.demo.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/interior")
public class InteriorPostController {

    private final InteriorPostService service;
    private final PostCommentService commentService;

    /** 글 목록 */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", service.findAll());
        return "interior/list";
    }

    /** 글 작성 폼 */
    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("dto", new InteriorPostDto());
        return "interior/write";
    }

    /** 글 작성 처리 + 파일 업로드 포함 */
    @PostMapping("/write")
    public String write(@ModelAttribute InteriorPostDto dto) {
        handleMultipleFiles(dto);
        service.save(dto);
        return "redirect:/interior";
    }

    /** 상세 보기 + 조회수 증가 + 댓글 조회 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        service.increaseViews(id);
        InteriorPostDto dto = service.findById(id);

        model.addAttribute("dto", dto);
        model.addAttribute("commentList", commentService.findByPostId(id));
        return "interior/detail";
    }

    // 댓글 등록
    @PostMapping("/{postId}/comment")
    public String addComment(@PathVariable Long postId,
                             @RequestParam String writer,
                             @RequestParam String content) {

        PostCommentDto comment = PostCommentDto.builder()
                .postId(postId)
                .writer(writer)
                .content(content)
                .build();

        commentService.save(comment);
        return "redirect:/interior/" + postId;
    }

    // 댓글 삭제
    @PostMapping("/{postId}/comment/delete/{commentId}")
    public String deleteComment(@PathVariable Long postId,
                                @PathVariable Long commentId) {
        commentService.delete(commentId);
        return "redirect:/interior/" + postId;
    }

    /** 수정 폼 */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("dto", service.findById(id));
        return "interior/write";
    }

    /** 수정  */
    @PostMapping("/edit")
    public String edit(@ModelAttribute InteriorPostDto dto) {
        handleMultipleFiles(dto);
        service.save(dto);
        return "redirect:/interior/" + dto.getPostId();
    }

    /** 삭제 */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/interior";
    }

    /** 파일 업로드 처리 */
    private void handleMultipleFiles(InteriorPostDto dto) {
        List<MultipartFile> files = dto.getFiles();
        if (files != null && !files.isEmpty()) {
            List<String> filePaths = new ArrayList<>();
            List<String> fileNames = new ArrayList<>();
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String originalName = file.getOriginalFilename();
                        String uniqueName = System.currentTimeMillis() + "_" + originalName;
                        File dest = new File(uploadDir + uniqueName);
                        file.transferTo(dest);

                        filePaths.add("/uploads/" + uniqueName);
                        fileNames.add(uniqueName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            dto.setFilePaths(String.join(",", filePaths));
            dto.setFileNames(String.join(",", fileNames));
        }
    }


}
