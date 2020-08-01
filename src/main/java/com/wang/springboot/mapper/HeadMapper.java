package com.wang.springboot.mapper;

import com.wang.springboot.pojo.Head;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/3 8:52
 */
@Mapper
public interface HeadMapper {
    @Select("select * from t_head order by created_time desc limit 5")
    List<Head> findAll();

    @Insert("insert into t_head(title,content,created_time) values(#{title},#{content},#{created_time})")
    void save(Head head);

    @Delete("delete from t_head where id = #{id}")
    void delete(Long id);
}
