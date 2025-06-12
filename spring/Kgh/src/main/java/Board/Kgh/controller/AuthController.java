package BOARD.KGH.controller;

import BOARD.KGH.dto.MemberDTO;
import BOARD.KGH.entity.Member;
import BOARD.KGH.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/signup")
    public String signupForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute MemberDTO dto){
        memberService.register(dto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDTO dto, HttpSession session){
        Member member = memberService.login(dto);
        if(member != null){
            session.setAttribute("loginUser", member);
            return "redirect:/boards";
        }else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); //세션종료
        return "redirect:/login";
    }
}
