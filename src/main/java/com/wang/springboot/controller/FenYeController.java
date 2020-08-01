package com.wang.springboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wang.springboot.mapper.FenYeMapper;
import com.wang.springboot.pojo.Blog;
import com.wang.springboot.service.BlogService;
import com.wang.springboot.service.TagService;
import com.wang.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王一宁
 * @date 2020/3/2 16:46
 */
@Controller
public class FenYeController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    FenYeMapper fenYeMapper;



    //http://localhost:8080/getUser?pageNum=1&pageSize=2
    @RequestMapping(value = {"/getBlog"})
    public String getBlog(HttpServletRequest request,
                          Integer pageNum, Integer pageSize, Model model) {

        if (pageNum == null && pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        if (pageNum != null && pageSize == null) {
            pageSize = 10;
        }

        String id1 = request.getParameter("id");
        Long id = Long.parseLong(id1);
        request.getSession().setAttribute("id", id1);

        PageHelper.startPage(pageNum, pageSize);
        Page<Blog> blogList = fenYeMapper.getBlogList(id);
        model.addAttribute("page", blogList);

        //model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("tags", tagService.listTagTop(100));//标签
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "list";
    }


    //第一种实现方式
    //http://localhost:8080/getUser?pageNum=1&pageSize=2
    @RequestMapping(value = {"/getBlog2"})
    public String getBlog2(HttpServletRequest request,
                          Integer pageNum, Integer pageSize, Model model) {

        if (pageNum == null && pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        if (pageNum != null && pageSize == null) {
            pageSize = 10;
        }

        String id2 = (String) request.getSession().getAttribute("id");
        Long id = Long.parseLong(id2);

        PageHelper.startPage(pageNum, pageSize);
        Page<Blog> blogList = fenYeMapper.getBlogList(id);
        model.addAttribute("page", blogList);

        //model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("tags", tagService.listTagTop(100));//标签
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "list";
    }

}
