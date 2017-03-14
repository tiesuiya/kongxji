package com.tiesuiya.kongxji.bean;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 日记内容
 *
 * @author lh
 * @since 1.0.0
 */
@Entity(name = "diary_content")
public class DiaryContent implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 16777215)
    private String content;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public DiaryContent() {
    }

    public DiaryContent(String content, Topic topic) {
        this.content = content;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
