package Board.Kgh.controller;

import Board.Kgh.entity.Board;
import Board.Kgh.entity.Member;
import Board.Kgh.service.BoardService;
import Board.Kgh.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyPageController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private MemberService memberService;


    @GetMapping("/mypage")
    public String myPage(Model model, HttpSession session){
        Member loginUser = (Member) session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login";

        //작성한 게시글 목록
        List<Board> myBoards = boardService.findByWriter(loginUser);
        model.addAttribute("myBoards", myBoards);
        return "mypage";
    }

    @PostMapping("/mypage/password")
    public String changePassword(@RequestParam String newPassword, HttpSession session){
        Member loginUser = (Member) session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login";
        memberService.changePassword(loginUser.getId(), newPassword);
        return "redirect:/mypage?success=password";
    }
}
