package com.wang.springboot.mapper;

import com.wang.springboot.pojo.Blog;
import com.wang.springboot.pojo.Comment;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/11 15:30
 */
@Mapper
public interface CommentMapper {
    /*查询所有的评论信息*/
    //@Select("SELECT a.content,a.email,a.nickname,a.create_time,b.title from t_comment a,t_blog b WHERE a.blog_id=b.id ORDER BY a.create_time DESC LIMIT 30;")
    List<Comment> findAll();

    @Delete("delete from t_comment where id = #{id}")
    void deleteById(Long id);
}
