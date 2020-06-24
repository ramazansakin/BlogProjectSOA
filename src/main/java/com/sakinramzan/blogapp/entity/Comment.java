package com.sakinramzan.blogapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Comment extends BaseEntity{

    private String text;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User creator;
}

