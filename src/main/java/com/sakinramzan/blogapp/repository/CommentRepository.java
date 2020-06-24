package com.sakinramzan.blogapp.repository;

import com.sakinramzan.blogapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends IGenericRepository<Comment> {
    List<Comment> findByPostId(Long postId);
}
