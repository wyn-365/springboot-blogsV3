package com.wang.springboot.mapper;

import com.wang.springboot.pojo.About;
import com.wang.springboot.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 王一宁
 * @date 2020/3/9 8:34
 */
@Mapper
public interface AboutMapper {
    @Select("select id,about from t_about")
    List<About> getAbout();

    @Select("select * from t_about where id = #{id}")
    About getAboutById(int id);

    @Insert("insert into t_about(about) values(#{about})")
    void save(About about);

    @Delete("delete from t_about where id = #{id}")
    void delete(int id);

    @Update("update t_about set about = #{about} where id = #{id}")
    void update(About aboutme);
}
