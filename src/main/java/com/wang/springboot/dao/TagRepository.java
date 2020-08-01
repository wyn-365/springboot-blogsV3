package com.wang.springboot.dao;


import com.wang.springboot.pojo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by limi on 2017/10/16.
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByName(String name);

    //前台查出标签
    @Query("select t from Tag t")
    public List<Tag> findTop(Pageable pageable);
}
