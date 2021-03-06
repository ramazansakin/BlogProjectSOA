package com.rsakin.blogapp.repository;

import com.rsakin.blogapp.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends IGenericRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}
