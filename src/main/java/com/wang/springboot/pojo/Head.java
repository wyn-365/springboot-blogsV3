package com.wang.springboot.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * @author 王一宁
 * @date 2020/3/3 8:43
 */
@Entity
@Table(name = "t_head")
public class Head {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    private Date created_time;

    public Head() {
    }

    @Override
    public String toString() {
        return "Head{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created_time=" + created_time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }
}
