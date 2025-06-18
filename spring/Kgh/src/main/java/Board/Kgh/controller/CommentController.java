package Board.Kgh.controller;

import Board.Kgh.entity.Comment;
import Board.Kgh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments/delete/{id}")
    public String deleteComment(@PathVariable Long id, @RequestParam(required = false) Long boardId, @RequestParam(defaultValue = "list") String from) {
        Comment comment = commentService.findById(id);
        if (comment == null) return "redirect:/boards";

        commentService.deleteComment(id);

        if ("detail".equals(from)) {
            return "redirect:/boards/detail/" + comment.getBoard().getId();
        } else {
            return "redirect:/boards";  // 리스트에서 삭제했으면 다시 리스트로
        }
    }

}
