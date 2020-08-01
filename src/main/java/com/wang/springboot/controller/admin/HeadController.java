package com.wang.springboot.controller.admin;

import com.wang.springboot.mapper.HeadMapper;
import com.wang.springboot.pojo.Head;
import com.wang.springboot.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 王一宁
 * @date 2020/3/3 9:44
 */
@Controller
@RequestMapping("/admin")
public class HeadController {

    @Autowired
    HeadMapper headMapper;

    @GetMapping("/heads")
    public String list(Model model) {
        List<Head> headList = headMapper.findAll();
        model.addAttribute("headList", headList);//
        return "admin/heads";
    }

    //点击新增呢个进入到新增公告的页面
    @GetMapping("/heads/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/heads-input";
    }


    //新增公告
    @PostMapping("/heads")
    public String post(HttpServletRequest request) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Head head = new Head();
        head.setTitle(title);
        head.setContent(content);
        head.setCreated_time(new Date());
        headMapper.save(head);
        return "redirect:/admin/heads";
    }


    //删除一个公告
    @GetMapping("/heads/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        headMapper.delete(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/heads";
    }

}
