package com.wang.springboot.service;

import com.wang.springboot.pojo.Comment;

import java.util.List;

/**
 * Created by limi on 2017/10/22.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    List<Comment> findAll();

    void delete(Long id);
}
