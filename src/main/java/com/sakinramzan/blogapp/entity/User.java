package com.sakinramzan.blogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @JsonIgnore
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    public <T> User(String username, String password, List<T> asList) {
        this.username = username;
        this.password = password;
        this.roles = (List<Role>) asList;
    }
}

