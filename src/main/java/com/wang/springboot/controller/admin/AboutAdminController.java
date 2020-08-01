package com.wang.springboot.controller.admin;

import com.wang.springboot.mapper.AboutMapper;
import com.wang.springboot.mapper.HeadMapper;
import com.wang.springboot.mapper.ProjectMapper;
import com.wang.springboot.pojo.About;
import com.wang.springboot.pojo.Project;
import com.wang.springboot.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/3 9:44
 */
@Controller
@RequestMapping("/admin")
public class AboutAdminController {
    @Autowired
    AboutMapper aboutMapper;

    @GetMapping("/about")
    public String list(Model model) {
        List<About> aboutList = aboutMapper.getAbout();
        model.addAttribute("aboutList", aboutList);
        return "admin/about";
    }

    //点击新增呢个进入到新增技能的页面
    @GetMapping("/about/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/about-input";
    }

    //点击编辑 进入到修改技能的页面
    @GetMapping("/about/{id}/update")
    public String update(@PathVariable int id, Model model) {

        About about = aboutMapper.getAboutById(id);

        model.addAttribute("about", about);
        return "admin/about-update";
    }



    //新增it技能
    @PostMapping("/about")
    public String post(HttpServletRequest request) {
        String about = request.getParameter("about");
        About aboutme = new About();
        aboutme.setAbout(about);
        aboutMapper.save(aboutme);
        return "redirect:/admin/about";
    }

    //修改it技能
    @PostMapping("/about/update")
    public String postUpdate(HttpServletRequest request) {
        String about = request.getParameter("about");
        String id = request.getParameter("id");
        About aboutme = new About();
        aboutme.setAbout(about);
        aboutme.setId(Integer.parseInt(id));
        aboutMapper.update(aboutme);
        return "redirect:/admin/about";
    }

    //删除一个技能
    @GetMapping("/about/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        aboutMapper.delete(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/about";
    }

}
