package com.sakinramzan.blogapp.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Post extends BaseEntity {

    private String title;
    private String body;
    private Date dateCreated;

    @ManyToOne
    private User creator;

}


