package com.sakinramzan.blogapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long Id;

    private String text;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User creator;

    public Comment(String text, Post post, User creator) {
        this.text = text;
        this.post = post;
        this.creator = creator;
    }
}

