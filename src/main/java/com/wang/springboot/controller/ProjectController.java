package com.wang.springboot.controller;

import com.wang.springboot.mapper.ProjectMapper;
import com.wang.springboot.pojo.Project;
import com.wang.springboot.service.ProjectService;
import com.wang.springboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Action;

/**
 * @author 王一宁
 * @date 2020/3/9 8:31
 */
@Controller
public class ProjectController {

    @Autowired
    TypeService typeService;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    ProjectService projectService;

    @RequestMapping("/getProjectById/{id}")
    public String getProjectById(@PathVariable("id") Long id, Model model) {
        //拿到分页的数据
        model.addAttribute("types", typeService.listTypeTop(1000));//分类
        //将数据库的内容进行html markdown转换
        Project project = projectService.getAndConvert(id);

        model.addAttribute("project", project);
        return "project";
    }
}
