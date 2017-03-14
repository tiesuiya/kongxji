package com.tiesuiya.kongxji.bean;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * 日记实体
 *
 * @author lh
 * @since 1.0.0
 */
@Entity(name = "diary")
public class Diary implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date updatedDate;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "d_id")
    private Set<DiaryContent> contents;

    public Diary() {
    }

    public Diary(Date createdDate, Date updatedDate, Set<DiaryContent> contents) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.contents = contents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Set<DiaryContent> getContents() {
        return contents;
    }

    public void setContents(Set<DiaryContent> contents) {
        this.contents = contents;
    }

}
