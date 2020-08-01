package com.wang.springboot.controller;

import com.wang.springboot.pojo.Tag;
import com.wang.springboot.service.BlogService;
import com.wang.springboot.service.TagService;
import com.wang.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 王一宁 on 2017/10/23.
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;
    @Autowired
    TypeService typeService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@PageableDefault(size = 10, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                       @PathVariable Long id, Model model) {
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            id = tags.get(0).getId();
        }
        model.addAttribute("tags", tags);
        model.addAttribute("page", blogService.listBlog(id, pageable));
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));//推荐
        model.addAttribute("activeTagId", id);
        model.addAttribute("clickBlogs", blogService.listClickBlogTop(8));//点击
        return "list3";
    }
}
