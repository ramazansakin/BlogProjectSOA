package com.rsakin.blogapp.repository;

import com.rsakin.blogapp.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends IGenericRepository<Post, Long> {
    List<Post> findByCreatorId(Long id);
}

