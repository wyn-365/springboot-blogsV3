package com.wang.springboot.controller;


import com.wang.springboot.service.BlogService;
import com.wang.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wangyining on 2017/10/23.
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/archives")
    public String archives(@PageableDefault(size = 38, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                           Model model) {
        //拿到分页的数据
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        //所有的博客
        //model.addAttribute("archiveMap", blogService.archiveBlog());
        //总的博客数量
        model.addAttribute("blogCount", blogService.countBlog());
        return "time";
    }
}
