package com.wang.springboot.pojo;

import javax.persistence.*;

/**
 * @author 王一宁
 * @date 2020/8/1 8:22
 */
@Entity
@Table(name = "t_about")
public class About {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String about;
    public About(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "About{" +
                "id=" + id +
                ", about='" + about + '\'' +
                '}';
    }
}
