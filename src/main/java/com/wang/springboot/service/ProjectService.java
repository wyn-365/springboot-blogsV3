package com.wang.springboot.service;

import com.wang.springboot.pojo.Blog;
import com.wang.springboot.pojo.Project;

/**
 * @author 王一宁
 * @date 2020/3/10 9:36
 */
public interface ProjectService {

    //markdown转换成html的详情页面的方法
    public Project getAndConvert(Long id);
}
