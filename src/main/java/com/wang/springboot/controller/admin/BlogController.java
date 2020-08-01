package com.wang.springboot.controller.admin;

import com.wang.springboot.pojo.Blog;
import com.wang.springboot.pojo.User;
import com.wang.springboot.service.BlogService;
import com.wang.springboot.service.TagService;
import com.wang.springboot.service.TypeService;
import com.wang.springboot.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 6, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                Pageable pageable,
                        BlogQuery blog,
                        Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs";
    }


    //之撒胡新博客表单内容 ajax
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 6, sort = {"updateTime"}, direction = Sort.Direction.DESC)
                                 Pageable pageable,
                         BlogQuery blog,
                         Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "admin/blogs :: blogList";
    }


    //跳转新增博客页面 需要查出标签和分类
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType()); //分类
        model.addAttribute("tags", tagService.listTag()); //标签

        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    //博客新增 传入一个session对象，因为session中有user的信息 后端的校验简单的
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {

        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTag(blog.getTagIds()));

        if (blog.getId()==null){
            blog.setViews(1);
        }else{
            Blog blog1 = blogService.getBlog(blog.getId());
            blog.setViews(blog1.getViews());
        }


        Blog b = blogService.saveBlog(blog);
        if (b == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return "redirect:/admin/blogs";
    }


    //跳转修改博客页面 需要查出标签和分类
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("types", typeService.listType()); //获取分类
        model.addAttribute("tags", tagService.listTag()); //获取标签

        Blog blog = blogService.getBlog(id);
        blog.init();

        model.addAttribute("blog", blog);
        return "admin/blogs-input";
    }


    //删除一条博客 返回列表
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/blogs";
    }
}
