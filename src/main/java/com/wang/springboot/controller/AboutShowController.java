package com.wang.springboot.controller;

import com.wang.springboot.mapper.AboutMapper;
import com.wang.springboot.mapper.ProjectMapper;
import com.wang.springboot.pojo.About;
import com.wang.springboot.pojo.Project;
import com.wang.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by 王一宁 on 2017/10/24.
 */
@Controller
public class AboutShowController {

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    AboutMapper aboutMapper;

    @Autowired
    TypeService typeService;

    @GetMapping("/about")
    public String about(Model model) {
        //拿到分页的数据
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        //取出个人项目集合
        List<Project> projectList = projectMapper.getProject();
        List<About> aboutList = aboutMapper.getAbout();
        model.addAttribute("projectList", projectList);
        model.addAttribute("aboutList", aboutList);
        return "about";
    }
}
