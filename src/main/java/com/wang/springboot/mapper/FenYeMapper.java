package com.wang.springboot.mapper;

import com.github.pagehelper.Page;
import com.wang.springboot.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 王一宁
 * @date 2020/3/2 17:38
 */
@Mapper
public interface FenYeMapper {
    @Select("select * from t_blog WHERE type_id=#{id} order by update_time desc")
    Page<Blog> getBlogList(Long id);
}
