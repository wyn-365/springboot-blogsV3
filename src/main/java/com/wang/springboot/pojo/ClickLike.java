package com.wang.springboot.pojo;

import javax.persistence.*;

/**
 * @author 王一宁
 * @date 2020/3/5 10:33
 */
@Entity
@Table(name = "t_clicklike")
public class ClickLike {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int blog_id;

    private int number;

    public ClickLike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ClickLike{" +
                "id=" + id +
                ", blog_id=" + blog_id +
                ", number=" + number +
                '}';
    }
}
