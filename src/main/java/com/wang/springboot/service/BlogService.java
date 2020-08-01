package com.wang.springboot.service;

import com.wang.springboot.pojo.Blog;
import com.wang.springboot.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    public Blog getBlog(Long id);

    //分页查询博客 两个查询条件 封装成一个对象
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    //新增
    public Blog saveBlog(Blog blog);

    public Blog updateBlog(Long id, Blog blog);

    public void deleteBlog(Long id);


    //前台的blog分页查询方法
    public Page<Blog> listBlog(Pageable pageable);

    //推荐的博客列表地
    public List<Blog> listRecommendBlogTop(Integer size);

    //定义搜索 的分页查询
    public Page<Blog> listBlog(String query, Pageable pageable);

    //markdown转换成html的详情页面的方法
    public Blog getAndConvert(Long id);

    //根据标签id 关联查询所有的博客列表
    public Page<Blog> listBlog(Long tagId, Pageable pageable);

    //归档查询
    public Map<String, List<Blog>> archiveBlog();

    //总的博客数量
    public Long countBlog();

    //推荐的博客列表地
    public List<Blog> listClickBlogTop(Integer size);

}
