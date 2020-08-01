package com.wang.springboot.dao;

import com.wang.springboot.pojo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.Max;
import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {

    //根据名称查询分类不能重复
    public Type findByName(String name);

    //前台获取分类 定义取出多少分类的数据 分页的大小来取
    @Query("SELECT t from Type t")
    public List<Type> findTop(Pageable pageable);
}
