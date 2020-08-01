package com.wang.springboot.service;

import com.wang.springboot.pojo.Tag;
import com.wang.springboot.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by limi on 2017/10/16.
 */
public interface TagService {

    Tag saveTag(Tag type);

    Object getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    //获取所有的标签
    List<Tag> listTag();

    List<Tag> listTag(String ids);

    Tag updateTag(Long id, Tag type);

    public void deleteTag(Long id);

    //前台查出标钱
    public List<Tag> listTagTop(Integer size);
}
