package com.sakinramzan.blogapp.repository;

import com.sakinramzan.blogapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends IGenericRepository<Post> {
    List<Post> findByCreatorId(Long id);
}

