package com.springboot.controller;

import com.springboot.domain.Mem;
import com.springboot.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;

@Controller
public class Ex01Controller {

//    @RequestMapping(value = "/exem01", method = RequestMethod.GET)  //GetMapping과 흡사
//    public String requestMethod(){
//        return "viewPage01";
//    }

    @GetMapping("/exem01")
    public String requestMethod(@RequestParam("id") String userId, @RequestParam("passwd") String userPw, Model model){
        //@RequestParam은 HTTP 요청의 쿼리 파라미터 값을 컨트롤러 메서드의 매개변수로 전달해주는 어노테이션
        model.addAttribute("data1", "@RequestParam 예제");
        model.addAttribute("data2", "요청 파라미터 id값: "+ userId +"<br>요청 파라미터 passwd 값"+ userPw);
        return "viewPage";
        //http://localhost:8080/exem01?id=admin&passwd=admin1234
    }

    @GetMapping("/exem03/{id}")
    public String requestMethod(@PathVariable("id") String userId, Model model){
        //@PathVariable은 URL 경로에 포함된 값을 컨트롤러 메서드의 매개변수로 전달해주는 어노테이션
        model.addAttribute("data1", "@PathVariable 예제");
        model.addAttribute("data2", "경로 변수 id값: "+ userId);
        return "viewPage03";
        //http://localhost:8080/exem03/1
    }

    @GetMapping("/exem05/{id}")
    public String requestMethod05(@PathVariable("id") String userId, @MatrixVariable("passwd") String userPw, Model model){
        //@MatrixVariable은 세미콜론(;)으로 구분된 URL 경로 내 매트릭스 변수 값을 컨트롤러 매개변수로 바인딩하는 어노테이션
        model.addAttribute("data1", "@MatrixVariable 예제");
        model.addAttribute("data2", "경로 변수 id값: "+ userId +"<br>매트릭스 변수 passwd 값"+ userPw);
        return "viewPage03";
        //http://localhost:8080/exem05/admin;passwd=admin1234
    }

    @GetMapping("/member")
    public String showForm(){
        return "viewPage02";
    }

    @PostMapping("/member")
    public String submitForm(@ModelAttribute Member member, Model model){
        model.addAttribute("member", member);
        return "viewPage021";
    }

    @InitBinder
    //@InitBinder는 요청 파라미터가 객체로 바인딩될 때, 허용하거나 차단할 필드를 설정할 수 있게 해주는 설정 메서드 어노테이션
    public void initBinder(WebDataBinder binder){
        binder.setAllowedFields("id","passwd","city","sex","greetings");
        //binder.setDisallowedFields("hobby");
    }
    
    
    
    //Multipart로 파일첨부
    @GetMapping("/exem01/form")
    public String requestForm() {
        return "viewPage71";
    }

    @PostMapping("/exem01/form")
    public String submitForm(MultipartHttpServletRequest request, Model model){
        String name = request.getParameter("name");
        MultipartFile file = request.getFile("fileImage");
        String filename   = file.getOriginalFilename();
        File saveFile = new File("c:\\upload\\" + name + "_" + filename );

        try {
            file.transferTo(saveFile);
            model.addAttribute("data1","MultipartHttpServletRequest 예졔" );
            model.addAttribute("data2",filename);
            model.addAttribute("data3", saveFile.getName() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "viewPage_process";
    }

    
    //RequestParam으로 파일 첨부
    @GetMapping("/exem01/form1")
    public String requestForm1() {
        return "viewPage71";
    }

    @PostMapping("/exem01/form1")
    public String submitForm1(@RequestParam("name") String name,
                             @RequestParam("fileImage") MultipartFile file, Model model) {
        String filename = file.getOriginalFilename();
        File saveFile = new File("c:\\upload\\" + name + "_" + filename);

        try {
            file.transferTo(saveFile);

            model.addAttribute("data1","@RequestParam 예졔" );
            model.addAttribute("data2",filename);
            model.addAttribute("data3", saveFile.getName() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "viewPage_process";
    }




    @GetMapping("/exem02/form")
    public String requestForm2(Mem mem) {
        return "viewPage72";
    }

    @PostMapping("/exem02/form")
    public String submitForm2(@ModelAttribute Mem mem, Model model) {
        String name = mem.getName();
        MultipartFile file = mem.getFileImage();
        String filename = file.getOriginalFilename();
        File saveFile = new File("c:\\upload\\" + name + "_" + filename);

        try {
            file.transferTo(saveFile);

            model.addAttribute("data1","@RequestParam 예졔" );
            model.addAttribute("data2",filename);
            model.addAttribute("data3", saveFile.getName() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "viewPage_process";
    }
}
