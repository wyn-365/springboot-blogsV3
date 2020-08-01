package com.wang.springboot.pojo;

import javax.persistence.*;

/**
 * @author 王一宁
 * @date 2020/3/5 10:49
 */
@Entity
@Table(name = "t_chrome")
public class Chrome {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String chrome;

    public Chrome() {
    }

    @Override
    public String toString() {
        return "Chrome{" +
                "id=" + id +
                ", chrome='" + chrome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChrome() {
        return chrome;
    }

    public void setChrome(String chrome) {
        this.chrome = chrome;
    }
}
