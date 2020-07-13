package com.sakinramzan.blogapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String body;
    private Date dateCreated;

    @ManyToOne
    private User creator;

}


