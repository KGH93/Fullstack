package Board.Kgh.controller;

import Board.Kgh.dto.BoardDTO;
import Board.Kgh.entity.Board;
import Board.Kgh.entity.Member;
import Board.Kgh.entity.Comment;
import Board.Kgh.service.BoardService;
import Board.Kgh.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;



    @GetMapping("/boards/write")
    public String writeform(HttpSession session){
        if(session.getAttribute("loginUser") == null){
            return "redirect:/login";
        }
        return "board-write";
    }

    @PostMapping("/boards/write")
    public String write(BoardDTO dto, HttpSession session) throws IOException {
        Member writer = (Member)session.getAttribute("loginUser");
        if(writer == null) return "redirect:/login";

        MultipartFile image = dto.getImageFile();
        String fileName = null;

        if (image != null && !image.isEmpty()) {
            String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
            fileName = image.getOriginalFilename();

            // 같은 이름이 이미 있으면 뒤에 숫자 붙이기
            File file = new File(uploadDir + fileName);
            int count = 1;
            while (file.exists()) {
                String name = fileName.substring(0, fileName.lastIndexOf('.'));
                String ext = fileName.substring(fileName.lastIndexOf('.'));
                file = new File(uploadDir + name + "_" + count + ext);
                count++;
            }

            fileName = file.getName(); // 최종 파일명 업데이트
            file.getParentFile().mkdirs(); // 디렉토리 없으면 생성
            image.transferTo(file);        // 파일 저장
        }

        dto.setImagePath(fileName);
        boardService.create(dto, writer);

        return "redirect:/boards";
    }




    @GetMapping("boards")
    public String list(Model model, HttpSession session){
        Member loginUser = (Member)session.getAttribute("loginUser");
        model.addAttribute("loginUser", loginUser);
        List<Board> boards = boardService.list();
        model.addAttribute("boards", boards);
        Map<Long, List<Comment>> commentMap = new HashMap<>();
        for(Board board : boards){
            commentMap.put(board.getId(), commentService.getComments(board));
        }
        model.addAttribute("commentMap", commentMap);
        return "board-list";
    }

    @GetMapping("/boards/detail/{id}")
    public String detail(@PathVariable Long id, Model model, HttpSession session) {
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/login";

        Board board = boardService.findById(id);
        List<Comment> comments = commentService.getComments(board); // 댓글 리스트 가져오기

        model.addAttribute("board", board);
        model.addAttribute("comments", comments); // 댓글도 모델에 추가
        model.addAttribute("loginUser", loginUser); // 댓글 삭제 버튼 조건부 렌더링 위해

        return "board-detail";
    }




    @PostMapping("comments/add")
    public String addComment(@RequestParam Long boardId, @RequestParam String content, HttpSession session){
        Member loginUser = (Member)session.getAttribute("loginUser");
        if(loginUser == null){
            return "redirect:login";
        }
        commentService.saveComment(boardId, content, loginUser);
        return "redirect:/boards";
    }



    @GetMapping("/boards/edit/{id}")
    public String editFoam(@PathVariable Long id, HttpSession session, Model model){
        Member loginUser = (Member)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login";
        Board board = boardService.findById(id);
        if(!board.getWriter().getId().equals(loginUser.getId())){
            return "redirect:/boards?error=unauthorized";
        }
        model.addAttribute("board",board);
        return "board-edit";
    }

    @PostMapping("/boards/edit/{id}")
    public String edit(@PathVariable Long id, HttpSession session, BoardDTO dto){
        Member loginUser = (Member)session.getAttribute("loginUser");
        if(loginUser == null) return "redirect:/login";
        Board board = boardService.findById(id);
        if(!board.getWriter().getId().equals(loginUser.getId())){
            return "redirect:/boards?error=unauthorized";
        }
        boardService.update(id,dto);
        return "redirect:/boards";
    }




    @PostMapping("/boards/delete/{id}")
    public String delete(@PathVariable Long id, HttpSession session) {
        Member loginUser = (Member) session.getAttribute("loginUser");
        if (loginUser == null) return "redirect:/login";

        Board board = boardService.findById(id);


        if (board == null || board.getWriter() == null) {
            return "redirect:/boards?error=notfound";
        }

        if (!board.getWriter().getId().equals(loginUser.getId())) {
            return "redirect:/boards?error=unauthorized";
        }

        boardService.delete(id);
        return "redirect:/boards";
    }



}
