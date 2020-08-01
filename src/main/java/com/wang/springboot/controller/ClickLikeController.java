/*
package com.wang.springboot.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wang.springboot.mapper.ClickLikeMapper;
import com.wang.springboot.pojo.Chrome;
import com.wang.springboot.pojo.ClickLike;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

*/
/**
 * @author 王一宁
 * @date 2020/3/5 10:21
 *//*

@Controller
public class ClickLikeController {

    @Autowired
    ClickLikeMapper clickLikeMapper;

    @RequestMapping(value = "/clickLike")
    @ResponseBody
    public ClickLike clickLike(HttpServletRequest request){
        //获取浏览器信息
        String chrome = request.getHeader("User-Agent");
        System.out.println(chrome);

        ClickLike clickLike = new ClickLike();

        //获取对应博客ID
        int id = 1;
        clickLike.setBlog_id(id);
        clickLike.setNumber(0);

        //查询数据库是否有该浏览器信息，判断是否点赞过？
        Chrome is = clickLikeMapper.findByChrome(chrome);

        try{
            if (is  == null){
                //保存浏览器信息
                clickLikeMapper.saveChrome(chrome);
                //实现点赞次数加一
                ClickLike blod = clickLikeMapper.findBlogId(id);
                //取出点赞的次数
                int numberClick = blod.getNumber();
                clickLike.setNumber(numberClick);
                if (blod != null){ //如果存在这条博客则更新
                    clickLikeMapper.updateNumber(id);
                }else { //插入
                    clickLikeMapper.increaseNumber(id);
                }
            }else { //数据库中已经有该浏览器信息了【我设置的不限次数点赞】
                //实现点赞次数加一
                ClickLike blod2 = clickLikeMapper.findBlogId(id);
                if (blod2 != null){
                    clickLikeMapper.updateNumber(id);
                }else {
                    clickLikeMapper.increaseNumber(id);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return clickLike;



    }
}
*/
