package com.wang.springboot.controller.admin;

import com.wang.springboot.pojo.Comment;
import com.wang.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/11 15:30
 */
@Controller
@RequestMapping("/admin")
public class CommentAdminController {
    @Autowired
    CommentService commentService;

    //关联的一对多所有的评论信息
    @RequestMapping("/comments")
    public String findAll(Model model) {
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList", commentList);
        return "admin/comments";
    }

    //删除一个评论
    @GetMapping("/comments/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        commentService.delete(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/comments";
    }

}
