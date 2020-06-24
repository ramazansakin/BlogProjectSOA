package com.sakinramzan.blogapp.service;

import com.sakinramzan.blogapp.entity.Comment;
import com.sakinramzan.blogapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public void comment(Comment comment) {
        commentRepository.save(comment);
    }

    public boolean deletePost(Long id) {
        commentRepository.deleteById(id);
        return true;
    }
}

