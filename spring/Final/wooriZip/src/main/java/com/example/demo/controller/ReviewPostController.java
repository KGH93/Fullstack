package com.example.demo.controller;

import com.example.demo.dto.ReviewPostDto;
import com.example.demo.entity.Users;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReviewPostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewPostController {

    private final ReviewPostService reviewService;
    private final ProductService productService;

    /** 후기 목록 */
    @GetMapping
    public String list(Model model) {
        List<ReviewPostDto> posts = reviewService.findAll();
        model.addAttribute("postList", posts);
        return "review/list";
    }

    /** 후기 작성 폼 */
    @GetMapping("/write")
    public String writeForm(Model model, HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/user/login";

        model.addAttribute("dto", new ReviewPostDto());
        model.addAttribute("loginUser", loginUser);

        // 추가: 상품 리스트 넘기기
        model.addAttribute("productList", reviewService.getAllProducts());

        return "review/write";
    }


    /** 후기 작성 처리 */
    @PostMapping("/write")
    @ResponseBody
    public String write(@ModelAttribute ReviewPostDto dto,
                        @RequestParam(value = "files", required = false) MultipartFile[] files,
                        HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) return "unauthorized";

        dto.setEmail(loginUser.getEmail());
        dto.setNickname(loginUser.getNickname());

        if (files != null && files.length > 0 && !files[0].isEmpty()) {
            handleMultipleFiles(dto, files);
        }

        try {
            reviewService.save(dto, loginUser);
        } catch (IllegalStateException e) {
            return "duplicate"; // 클라이언트에서 처리 가능
        }

        return "success";
    }


    /** 후기 상세보기 */
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        ReviewPostDto dto = reviewService.findById(id);
        model.addAttribute("dto", dto);
        model.addAttribute("loginUser", loginUser);
        return "review/detail";
    }

    /** 후기 수정 폼 */
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model, HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/user/login";

        ReviewPostDto dto = reviewService.findById(id);
        if (!dto.getEmail().equals(loginUser.getEmail())) {
            return "redirect:/review/" + id;
        }

        //  상품 목록 추가
        model.addAttribute("dto", dto);
        model.addAttribute("productList", productService.findAll());  // 이 메서드 필요
        model.addAttribute("loginUser", loginUser);
        return "review/edit";
    }


    /** 후기 수정 처리 */
    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ModelAttribute ReviewPostDto dto,
                       @RequestParam(value = "files", required = false) MultipartFile[] files,
                       @RequestParam(value = "deleteIndexes", required = false) List<Integer> deleteIndexes,
                       HttpSession session) {

        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) return "unauthorized";

        dto.setEmail(loginUser.getEmail());
        dto.setNickname(loginUser.getNickname());

        // 기존 이미지 유지
        List<String> existingPaths = new ArrayList<>();
        List<String> existingNames = new ArrayList<>();
        if (dto.getFilePaths() != null && !dto.getFilePaths().isEmpty()) {
            existingPaths = new ArrayList<>(List.of(dto.getFilePaths().split(",")));
        }
        if (dto.getFileNames() != null && !dto.getFileNames().isEmpty()) {
            existingNames = new ArrayList<>(List.of(dto.getFileNames().split(",")));
        }

        // 삭제 인덱스 처리
        if (deleteIndexes != null && !deleteIndexes.isEmpty()) {
            deleteIndexes.sort(Comparator.reverseOrder());
            for (int index : deleteIndexes) {
                if (index >= 0 && index < existingPaths.size()) {
                    String path = existingPaths.get(index);
                    File file = new File(System.getProperty("user.dir") + path);
                    if (file.exists()) file.delete();
                    existingPaths.remove(index);
                    existingNames.remove(index);
                }
            }
        }

        // 새 이미지 업로드가 있는 경우만 처리
        if (files != null && files.length > 0 && !files[0].isEmpty()) {
            List<String>[] result = handleAndReturnFiles(files);
            existingPaths.addAll(result[0]);
            existingNames.addAll(result[1]);
        }

        dto.setFilePaths(String.join(",", existingPaths));
        dto.setFileNames(String.join(",", existingNames));

        reviewService.save(dto, loginUser); // save()는 수정도 처리
        return "success";
    }


    /** 후기 삭제 */
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        Users loginUser = (Users) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/user/login";
        reviewService.delete(id);
        return "redirect:/review";
    }

    /** 파일 업로드 핸들러 (InteriorPost 복붙 구조) */
    private void handleMultipleFiles(ReviewPostDto dto, MultipartFile[] files) {
        if (files == null || files.length == 0) return;
        List<String>[] result = handleAndReturnFiles(files);
        dto.setFilePaths(String.join(",", result[0]));
        dto.setFileNames(String.join(",", result[1]));
    }

    private List<String>[] handleAndReturnFiles(MultipartFile[] files) {
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

        return new List[]{filePaths, fileNames};
    }
}
