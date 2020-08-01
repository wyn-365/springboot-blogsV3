package com.wang.springboot.dao;

import com.wang.springboot.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {

    //推荐
    @Query("select b from Blog b where b.recommend = true order by update_time desc")
    public List<Blog> findTop(Pageable pageable);

    //点击排行
    @Query("select b from Blog b where b.recommend = true order by views desc ")
    public List<Blog> clickTop(Pageable pageable);

    //定义搜索 的分页查询
    @Query("select b from Blog b where b.title like ?1 or b.content like?1")
    public Page<Blog> findByQuery(String query, Pageable pageable);


    //浏览次数增加
    @Transactional
    @Modifying
    @Query("update Blog b set b.views = b.views+1 where id = ?1")
    public int updateViews(Long id);

    //按照年份对博客进行归档查询
    @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc")
    List<String> findGroupYear();

    //总的博客数量
    @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
    List<Blog> findByYear(String year);

}
