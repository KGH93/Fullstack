package com.example.demo.controller;

import com.example.demo.dto.InteriorPostDto;
import com.example.demo.dto.PostCommentDto;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.InteriorPostService;
import com.example.demo.service.PostCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final MemberRepository memberRepository;

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
    public String write(@ModelAttribute InteriorPostDto dto,
                        @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();
        dto.setEmail(email);

        // 닉네임 조회 후 dto에 세팅
        String nickname = memberRepository.findByEmail(email)
                .map(member -> member.getNickname())
                .orElse("익명");

        dto.setNickname(nickname);

        handleMultipleFiles(dto);
        service.save(dto);
        return "redirect:/interior";
    }

    /** 상세 보기 + 조회수 증가 + 댓글 조회 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id,
                         Model model,
                         @AuthenticationPrincipal UserDetails userDetails) {

        service.increaseViews(id);
        InteriorPostDto dto = service.findById(id);

        model.addAttribute("dto", dto);
        model.addAttribute("commentList", commentService.findByPostId(id));

        // 로그인 사용자 닉네임 전달
        if (userDetails != null) {
            String email = userDetails.getUsername();
            String nickname = memberRepository.findByEmail(email)
                    .map(member -> member.getNickname())
                    .orElse("익명");

            model.addAttribute("nickname", nickname);
        }

        return "interior/detail";
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



    /** 댓글 등록 */
    @PostMapping("/{postId}/comment")
    public String addComment(@PathVariable Long postId,
                             @RequestParam String content,
                             @AuthenticationPrincipal UserDetails userDetails) {

        String email = userDetails.getUsername();
        String nickname = memberRepository.findByEmail(email)
                .map(member -> member.getNickname())
                .orElse("익명");

        PostCommentDto comment = PostCommentDto.builder()
                .postId(postId)
                .email(email)
                .nickname(nickname)
                .content(content)
                .build();

        commentService.save(comment);
        return "redirect:/interior/" + postId;
    }

    /** 댓글 삭제 */
    @PostMapping("/{postId}/comment/delete/{commentId}")
    public String deleteComment(@PathVariable Long postId,
                                @PathVariable Long commentId,
                                @AuthenticationPrincipal UserDetails userDetails) {

        PostCommentDto dto = commentService.findById(commentId);
        String loginEmail = userDetails.getUsername();

        if (!dto.getEmail().equals(loginEmail)) {
            return "redirect:/interior/" + postId; // 본인 아님 → 차단
        }

        commentService.delete(commentId);
        return "redirect:/interior/" + postId;
    }

    /** 댓글 수정 */
    @PostMapping("/{postId}/comment/edit/{commentId}")
    public String editComment(@PathVariable Long postId,
                              @PathVariable Long commentId,
                              @RequestParam String content,
                              @AuthenticationPrincipal UserDetails userDetails) {

        PostCommentDto dto = commentService.findById(commentId);
        String loginEmail = userDetails.getUsername();

        if (!dto.getEmail().equals(loginEmail)) {
            return "redirect:/interior/" + postId;
        }

        dto.setContent(content);
        commentService.update(dto); // update 메서드 만들어야 함
        return "redirect:/interior/" + postId;
    }


}
