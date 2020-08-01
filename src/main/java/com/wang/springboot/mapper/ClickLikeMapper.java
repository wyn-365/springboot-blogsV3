package com.wang.springboot.mapper;

import com.wang.springboot.pojo.Chrome;
import com.wang.springboot.pojo.ClickLike;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 王一宁
 * @date 2020/3/5 10:38
 */
@Mapper
public interface ClickLikeMapper {
    //查询是否有该浏览器信息
    @Select("select * from t_chrome where chrome = #{chrome}")
    Chrome findByChrome(String chrome);

    //没有的话插入浏览器信息
    @Insert("insert into t_chrome(chrome) values(#{chrome})")
    void saveChrome(String chrome);

    //是否有博客信息
    @Select("select * from t_clicklike where blog_id = #{id}")
    ClickLike findBlogId(int id);

    //更新数据
    @Update("update t_clicklike set number = number+1 where blog_id = #{id}")
    void updateNumber(int id);

    //点赞次数加一
    @Insert("insert into t_clicklike(blog_id,number) values (#{id},number=number+1)")
    void increaseNumber(int id);
}
