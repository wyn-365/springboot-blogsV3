package com.wang.springboot.service;

import com.wang.springboot.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface TypeService {
    //新增分类
    public Type saveType(Type type);

    //查询分类根据id
    public Type getType(Long id);

    //分页查询
    public Page<Type> listType(Pageable pageable);

    //修改
    public Type updateType(Long id, Type type);

    //删除分类
    public void deleteType(Long id);

    //通过名称查询分类，不可重复
    public Type getTypeByName(String name);


    //查询所有的分类
    public List<Type> listType();


    //前台获取分类 定义取出多少分类的数据
    public List<Type> listTypeTop(Integer size);


}
