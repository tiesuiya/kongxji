package com.tiesuiya.kongxji.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 话题实体
 *
 * @author lh
 * @since 1.0.0
 */
@Entity(name = "topic")
public class Topic implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;

    public Topic() {
    }

    public Topic(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
