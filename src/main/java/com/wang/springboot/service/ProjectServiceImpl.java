package com.wang.springboot.service;

import com.wang.springboot.NotFoundException;
import com.wang.springboot.mapper.ProjectMapper;
import com.wang.springboot.pojo.Blog;
import com.wang.springboot.pojo.Project;
import com.wang.springboot.utils.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 王一宁
 * @date 2020/3/10 9:36
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Override
    public Project getAndConvert(Long id) {
        Project project = projectMapper.getProjectById(id);
        if (project == null) {
            throw new NotFoundException("项目不存在");
        }
        Project p = new Project();
        BeanUtils.copyProperties(project, p);
        String content = p.getContent();
        p.setContent(MarkdownUtils.markdownToHtml(content));
        return p;
    }
}
