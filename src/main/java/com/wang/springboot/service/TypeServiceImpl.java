package com.wang.springboot.service;

import com.wang.springboot.NotFoundException;
import com.wang.springboot.dao.TypeRepository;
import com.wang.springboot.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.getOne(id);
    }

    @Transactional
    @Override//分页查询
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.getOne(id);
        if (t == null) {
            throw new NotFoundException("不存在这样的类型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }

    //更具名成查询分类 不能重复
    @Override
    public Type getTypeByName(String name) {

        return typeRepository.findByName(name);
    }

    //查询所有的分类
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }

    //前台获取分类 定义取出多少分类的数据
    @Override
    public List<Type> listTypeTop(Integer size) {
        //Sort sort = new Sort(Sort.Direction.DESC,"blog.size");
        Pageable pageable = PageRequest.of(0, size);

        return typeRepository.findTop(pageable);
    }
}
