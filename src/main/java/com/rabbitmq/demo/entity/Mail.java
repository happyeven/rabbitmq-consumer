package com.rabbitmq.demo.entity;

import java.io.Serializable;

/**
 * @Author ZHUDO2
 * @Date 8/9/2020 2:22 PM
 * @Version 1.0
 */
public class Mail implements Serializable{
    private Integer id;
    private String to;
    private String subject;
    private String content;

    public Mail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
