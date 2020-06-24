package com.sakinramzan.blogapp.repository;

import com.sakinramzan.blogapp.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends IGenericRepository<Post, Long> {
    List<Post> findByCreatorId(Long id);
}

