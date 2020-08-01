package com.wang.springboot.controller;

import com.wang.springboot.dao.BlogRepository;
import com.wang.springboot.mapper.HeadMapper;
import com.wang.springboot.pojo.Blog;
import com.wang.springboot.pojo.Head;
import com.wang.springboot.pojo.Type;
import com.wang.springboot.service.BlogService;
import com.wang.springboot.service.TagService;
import com.wang.springboot.service.TypeService;
import com.wang.springboot.vo.BlogQuery;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class IndexController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    HeadMapper headMapper;



    @GetMapping("/")
    public String index(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model) {

        List<Head> headList = headMapper.findAll();
        model.addAttribute("headList", headList);

        //拿到分页的数据
        model.addAttribute("page", blogService.listBlog(pageable));

        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("tags", tagService.listTagTop(100));//标签
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "index";
    }


    //查看博客详细信息
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("tags", tagService.listTagTop(100));//标签
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("blog", blogService.getAndConvert(id)); //zhuanchenghtml的博客
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "info";
    }

    //全局查询，搜索页面
    @PostMapping("/search")
    public String search(@PageableDefault(size = 20, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, Model model) {
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("tags", tagService.listTagTop(100));//标签
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("page", blogService.listBlog("%" + query + "%", pageable));//注意
        model.addAttribute("query", query);//注意返回页面
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "list2";
    }


    //页面底部的最新展示
    @GetMapping("/footer/newblog")
    public String newBlog(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}
