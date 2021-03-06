package com.rsakin.blogapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User creator;
}

